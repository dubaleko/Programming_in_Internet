<%@ page contentType="text/html;charset=UTF-16" language="java" %>
<html>
<head>
    <title>Register</title>
    <style>
        .error{
            color: red;
            font-size: 18px;
        }
    </style>
</head>
<body>
Register new account
<br/>
<c:if test="${not empty error}">
    <span class="error">${error}</span>
</c:if>
<br/>
<form action="register" method="POST">
    Username: <input name = "username" />
    <br/><br/>
    Password: <input name = "password" />
    <br/><br/>
    Retry Password: <input name="retry" />
    <br/><br/>
    <input type="submit" value="Register" />
</form>
</body>
</html>
