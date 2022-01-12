import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.URL;

import java.net.URLConnection;

import java.util.HashMap;
import java.util.PriorityQueue;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;



public class GoogleQuery 

{

	public String searchKeyword;

	public String url;

	public String content;
	
//	public PriorityQueue<WebNode> heap;

	public GoogleQuery(String searchKeyword)
	{
		this.searchKeyword = searchKeyword.replaceAll(" ", "");
		this.searchKeyword = this.searchKeyword.replaceAll("!", "");
		this.searchKeyword = this.searchKeyword.replaceAll("#", "");
		this.searchKeyword = this.searchKeyword.replaceAll("@", "");
		this.searchKeyword = this.searchKeyword.replaceAll("^", "");
		this.searchKeyword = this.searchKeyword.replaceAll("%", "");
		if(this.searchKeyword.getBytes().length==this.searchKeyword.length()) {
			if(!this.searchKeyword.contains("ratatouille")) {this.searchKeyword+="ratatouillemovie";}
			if(!this.searchKeyword.contains("Rémy")) {this.searchKeyword+="Rémy";}
		}else {
			if(!this.searchKeyword.contains("小米")) {this.searchKeyword+="小米";}
			if(!this.searchKeyword.contains("料理鼠王")) {this.searchKeyword+="料理鼠王";}
		}
		System.out.print(this.searchKeyword);
		this.url = "http://www.google.com/search?q="+this.searchKeyword+"&oe=UTF-8&num=20";

	}

	

	private String fetchContent() throws IOException

	{
		String retVal = "";

		URL u = new URL(url);

		URLConnection conn = u.openConnection();

		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");

		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in,"UTF-8");
		

		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while((line=bufReader.readLine())!=null)
		{
			retVal += line;

		}
		return retVal;
	}
	public HashMap<String, String> query() throws IOException

	{

		if(content==null)

		{

			content= fetchContent();

		}
		

		HashMap<String, String> retVal = new HashMap<String, String>();
		//System.out.print(content);
		Document doc = Jsoup.parse(content);
		//System.out.print(doc);
		Elements lis = doc.select("div");
		//System.out.println(lis);
		lis = lis.select(".kCrYT");
		//yuRUbf
		//kCrYT
		//System.out.println(lis);
		
		for(Element li : lis)
		{
			try 
			{
				String citeUrl = li.select("a").get(0).attr("href");
				citeUrl = citeUrl.substring(7,citeUrl.indexOf("&sa=U&ved=2"));
				String title = li.select("a").get(0).select(".vvjwJb").text();
				
				if(title.equals("")) {
					continue;
				} 
				//System.out.println(title + ":"+citeUrl);
				retVal.put(title, citeUrl);
				
				

			} catch (IndexOutOfBoundsException e) {

//				e.printStackTrace();

			}

			

		}

		

		return retVal;

	}

	

	

}