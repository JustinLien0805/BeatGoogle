<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>GoogleSearch</title>
    <style type="text/css">
      #padding {
        padding: 0px 0px 15px 15px;
      }
      a {
        color: #0b173b;
        font-size: 30px;
        text-decoration: none;
      }
      a:hover {
        text-decoration: underline;
      }
      .border-style {
        border-radius: 90px/90px;
      }
    </style>
  </head>

  <body style="background-color: #e68a3f">
  <input type="image" name="homePage" onclick='history.back().submit()' src="img/小米.png" style="position: absolute;
                  width: 230px;
                  height: 120px;
                  left: 50%;
                  top: 50%;
                  margin-top: -360px;
                  margin-left: -700px;
                "
          >
    <form action="${requestUri}" method="get">
      <div style="position: absolute; margin-top: 190px; margin-left: 50px">
        <% String[][] orderList = (String[][]) request.getAttribute("query");
        for (int i = 0; i < orderList.length; i++) { String s=orderList[i][1];
        %>

        <a href="<%=s%>"><%="ʢ•·̫•ʡ "+orderList[i][0]%> </a> <br />------◅
        ʢ•·̫•ʡ------◅ ʢ•·̫•ʡ-------◅ ʢ•·̫•ʡ------◅ ʢ•·̫•ʡ------◅ ʢ•·̫•ʡ------◅
        ʢ•·̫•ʡ------<br />
        <br />
        <% } %>
      </div>
      <div>
        <h1
          style="
            position: absolute;
            left: 50%;
            top: 50%;
            margin-top: -340px;
            margin-left: -540px;
            font-size: 60px;
            font-family: 'Apple Chancery';
            color: #014ba0;
          "
        >
          RÉMY
        </h1>
      </div>
      <div>
        <input
          type="text"
          class="border-style"
          id="padding"
          name="keyword"
          style="
            font-size: 120%;
            position: absolute;
            left: 50%;
            top: 48%;
            margin-top: -300px;
            margin-left: -330px;
            width: 800px;
            height: 25px;
          "
          placeholder="請輸入關鍵字"
          value='<%=request.getParameter("keyword")%>'
        />
        <input
          type="image"
          src="img/起司.png"
          style="
            position: absolute;
            width: 120px;
            height: 120px;
            left: 50%;
            top: 50%;
            margin-top: -360px;
            margin-left: 480px;
          "
        />
      </div>
    </form>
  </body>
</html>