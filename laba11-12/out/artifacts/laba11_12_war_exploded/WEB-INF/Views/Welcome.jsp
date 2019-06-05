<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
Hello <%out.println(request.getAttribute("newusername").toString());%> Now date on server <%out.println(request.getAttribute("date").toString());%>
<br/><br/>
Your friends list
<br/><br/>
<form action="info" method="POST">
    Name: <input name = "name" />
    <br/><br/>
    Phone: <input name = "phone" />
    <br/><br/>
    Email: <input name="email" >
    <input type="submit" value="Add" />
</form>
<br/>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Phone</td>
        <td>Email</td>
    </tr>
    <c:forEach var="num" items="${list}" >
        <tr>
            <td>${num.getName()}</td>
            <td>${num.getPhone()}</td>
            <td>${num.getEmail()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
