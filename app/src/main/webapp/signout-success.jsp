<%@ page import="java.util.Date" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="model.entitity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
</head>

<body>
<h1><%=request.getAttribute("email") + " successfully signed out!" %>
</h1>
<br>
<a href="http://localhost:8080/projet-template-1.0-SNAPSHOT/">Home</a>
</body>
</html>