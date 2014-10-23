<%--
  Created by IntelliJ IDEA.
  User: bin.zhang
  Date: 2014/7/18
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://jqueryjs.googlecode.com/files/jquery-1.3.2.min.js" type="text/javascript"></script>

    <script type="text/javascript">
          function getFromServer(){
              alert("开始");
            $.ajax({
                type : "GET",
                url : "/admin/getUser.do",
                data : "",
                contentType : "application/json",
                dataType : "json",
                success : function(obj){
                    alert("Data Saved: " + JSON.stringify(obj));
                },
                error : function(obj, s1, s2){
                    alert(JSON.stringify(obj));
                },
                complete : function (obj,s1) {
                    alert("complete: "+s1);
                }
            });
        }
        function commitToServer(){
            alert("commit to server");
            var userInfo = {};
            userInfo.userName = "bin.zhang";
            userInfo.passWord = "987654";
            $.ajax({
                type : "post",
                url : "/admin/commitToServer.do",
                data : JSON.stringify(userInfo),
                contentType : "application/json",
                dataType : "json",
                success : function(obj){
                    alert("Data Saved: " + JSON.stringify(obj));
                },
                error : function(obj, s1, s2){
                    alert(JSON.stringify(obj));
                },
                complete : function (obj,s1) {
                    alert("complete: "+s1);
                }
            });
        }

          function login(){
              var userInfo = {};
              userInfo.userName= document.getElementById("userName").value;
              userInfo.passWord  = document.getElementById("passWord").value;
              $.ajax({
                  type : "post",
                  url : "/testShiro.do",
                  data : JSON.stringify(userInfo),
                  contentType : "application/json",
                  dataType : "json",
                  success : function(obj){
//                      alert("Data Saved: " + JSON.stringify(obj));
                      alert("登录成功");
                      document.getElementById("login").style.visibility = "hidden";
                      document.getElementById("logout").style.visibility = "visible";
                      document.getElementById("success").value = userInfo.userName;
                  },
                  error : function(obj, s1, s2){
                      alert(JSON.stringify(obj));
                  },
                  complete : function (obj,s1) {
                      alert("complete: "+s1);
                  }
              });
          }


          function logout(){
              $.ajax({
                  type : "post",
                  url : "/logout.do"
              });
              document.getElementById("login").style.visibility = "visible";
              document.getElementById("logout").style.visibility = "hidden";
              document.getElementById("success").value = "";
          }
    </script>

    <title>test</title>
</head>
<body>
        <input value="接受服务器收据" type="button" onclick="getFromServer()"/>
        <input value="传送数据给服务器" type="button" onclick="commitToServer()">
        <div id="login">
        <br>
        用户名：<input id="userName">
        <br>
        密&nbsp;码：<input id="passWord" type="password">
        <br>
        <input value="登录" type="button" onclick="login()"/>
        </div>
        <input id="logout" value="注销" type="button" onclick="logout()" style="visibility: hidden">
        <br>
        <output id="success"/>
</body>
</html>
