

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProject
 */
@WebServlet("/TestProject")
public class TestProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static double[] scores= new double[80];
	static String[][] s = new String[80][2];
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("keyword")== null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}
		String searchword = request.getParameter("keyword");
		GoogleQuery google = new GoogleQuery(searchword);
		HashMap<String, String> query = google.query();
		s = new String[query.size()][2];
		//System.out.println(query.size());
		int num = 0;
		for (Entry<String, String> entry : query.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			s[num][0] = key;
			s[num][1] = value;
			System.out.println(s[num][0] + ":" + s[num][1]);
			num++;
		}
		sort(s);
		request.setAttribute("query", s);
		request.getRequestDispatcher("googleitem.jsp")
		 .forward(request, response); 
		request.removeAttribute("query");
	}
	
	public static void sort(String[][] link)  {
		ArrayList<Keyword> keywords = new ArrayList<Keyword>();
		Keyword k1 = new Keyword("小米", 20);
		Keyword k2 = new Keyword("老鼠", 10);
		Keyword k3 = new Keyword("小林", 5);
		Keyword k4 = new Keyword("大米", 8);
		Keyword k5 = new Keyword("Ratatouille", 8);
		Keyword k6 = new Keyword("米老鼠", -20);
		Keyword k7 = new Keyword("手機", -100);
		Keyword k8 = new Keyword("Ratatouille", 10);
		Keyword k9 = new Keyword("Rémy", 20 );
		Keyword k10 = new Keyword("燉菜", 5);
		Keyword k11 = new Keyword("movie", 8);
		Keyword k12=new Keyword("料理鼠王",10);
		keywords.add(k1);
		keywords.add(k2);
		keywords.add(k3);
		keywords.add(k4);
		keywords.add(k5);
		keywords.add(k6);
		keywords.add(k7);
		keywords.add(k8);
		keywords.add(k9);
		keywords.add(k10);
		keywords.add(k11);
		keywords.add(k12);
		scores= new double[link.length];
		for(int num=0;num<link.length;num++) {
			//System.out.println(link[num][1]+link[num][0]);
			WebPage rootPage = new WebPage(link[num][1],link[num][0]);		
			WebTree tree = new WebTree(rootPage);
			try {
				tree.setPostOrderScore(keywords);
				scores[num]=tree.eularPrintTree();
				System.out.println(link[num][0]+" to read");
				System.out.println(tree.eularPrintTree());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(link[num][0]+" fail to read");
				System.out.println("-500");
				scores[num]=-500;
			}
			}
		quickSort(0,scores.length-1);
		System.out.println("-------------");
		for(int i=0;i<scores.length;i++) {
			System.out.println(s[i][0]);
			System.out.println(s[i][1]);
			System.out.println(scores[i]);
		}
		}
	public static void swap(int aIndex, int bIndex){
		double temp = scores[aIndex];
		String a=s[aIndex][0];
		String b=s[aIndex][1];
		s[aIndex][0]=s[bIndex][0];
		s[aIndex][1]=s[bIndex][1];
		s[bIndex][0]=a;
		s[bIndex][1]=b;
		scores[aIndex]=scores[bIndex];
		scores[bIndex]=temp;
	}
	  private static void quickSort(int left, int right) {
	        if(left < right) { 
	            int q = partition(left, right); 
	            quickSort( left, q-1); 
	            quickSort( q+1, right); 
	        } 
	    }

	    private static int partition( int left, int right) {  
	        int i = left - 1; 
	        for(int j = left; j < right; j++) { 
	            if(scores[j] >= scores[right]) { 
	                i++; 
	                swap(i, j); 
	            } 
	        } 
	        swap(i+1, right); 
	        return i+1; 
	    } 



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

