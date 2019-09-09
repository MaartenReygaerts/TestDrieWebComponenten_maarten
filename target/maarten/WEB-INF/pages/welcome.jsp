<%--
  Created by IntelliJ IDEA.
  User: maart
  Date: 09/09/2019
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome ${name}</h1>

<form method="POST" action="logout">
    <input type="submit" name="logout" value="Log out">

</form>

</body>
</html>
