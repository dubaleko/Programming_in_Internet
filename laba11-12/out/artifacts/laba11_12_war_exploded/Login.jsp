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
