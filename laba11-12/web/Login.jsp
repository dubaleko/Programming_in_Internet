<%--
  Created by IntelliJ IDEA.
  User: Valentin
  Date: 31.05.2019
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-16" language="java"%>
<html>
<head>
    <title>Login</title>
    <style>
        .error{
            color: red;
            font-size: 18px;
        }
    </style>
</head>
<body>
Sign in account
<br/>
<c:if test="${not empty error}">
    <span class="error">${error}</span>
</c:if>
<br/>
<form action="sign" method="POST">
    Username: <input name = "username" />
    <br/><br/>
    Password: <input name = "password" />
    <br/><br/>
    <input type="submit" value="Sign in" />
</form>
<form action="Register.jsp" method="get">
<input type="submit" value="Register">
</form>
</body>
</html>
