<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>GoogleSearch</title>
    <style type="text/css">
      .body {
        background-size: auto;
      }
      .button {
        position: absolute;
        width: 125px;
        height: 45px;
        font-size: 15px;
        left: 50%;
        top: 50%;
      }

      .border-style {
        border-radius: 75px/90px;
      }

      #padding {
        padding: 0px 0px 0px 15px;
      }

      .box {
        position: relative;
      }

      .box:before {
        content: "";
        position: absolute;
        z-index: 2;
        top: 60px;
        left: 50px;
        width: 50px;
        height: 50px;
        border-radius: 2px;
        transform: rotate(45deg);
        -webkit-animation: box 1.25s infinite;
      }
    </style>
    <script type="text/javascript">
    </script>
  </head>
  <body style="background-color: #c57834">
    <form action="${requestUri}" method="get">
      <div>
        <input
          type="text"
          class="border-style"
          id="padding"
          style="
            font-size: 120%;
            position: absolute;
            left: 50%;
            top: 48%;
            margin-top: -47px;
            margin-left: -400px;
            width: 800px;
            height: 45px;
          "
          name="keyword"
          placeholder="請輸入關鍵字"
          onfocus="placeholder= '' "
          onblur="placeholder='請輸入關鍵字'"
        />
      </div>
    
      <div>
        <input
          type="image"
          src="img/起司.png"
          style="
            position: absolute;
            width: 150px;
            height: 150px;
            left: 50%;
            top: 50%;
            margin-top: -130px;
            margin-left: 400px;
          "
        />
      </div>
      <div>
        <a href="http://localhost:8080/Final_Project/TestProject"
          ><img
            src="img/小米.png"
            style="
              position: absolute;
              width: 400px;
              height: 250px;
              left: 50%;
              top: 50%;
              margin-top: -300px;
              margin-left: -420px;
            "
        /></a>
        <h1
          style="
            position: absolute;
            left: 50%;
            top: 50%;
            margin-top: -280px;
            margin-left: -150px;
            font-size: 150px;
            font-family: 'Apple Chancery';
            color: #014ba0;
          "
        >
          RÉMY
        </h1>
      </div>
      <div
        style="
          position: absolute;
          top: 0%;
          display: flex;
          justify-content: center;
          align-items: baseline;
          flex-direction: row;
        "
      >
        <img src="img/起司.png" style="height: 50px; width: 50px" />
      </div>
      <img
        src="img/image-removebg-preview (11).png"
        style="
          position: absolute;
          right: 40px;
          bottom: 30px;
          width: 25%;
          height: 40%;
        "
      />
      <img
        src="img/未命名 ‑ Made with FlexClip (1).gif"
        style="
          position: absolute;
          right: 65%;
          bottom: 5%;
          width: 30%;
          height: 30%;
        "
      />
    </form>
  </body>
</html>
    