<%@ page import="java.util.Date" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
</head>

<body>
<h1><%= "Success!" %>
</h1>
<h2><%= ((User)request.getAttribute("user")).toString() %>
</h2>
<div>
    <form action='update' method='POST'>
        Delete: <input type="checkbox" value="True" name="delete"/> <br/>
        <input name="email" type="text" value="<%= ((User)request.getAttribute("user")).getEmail() %>" hidden>
        <input type='submit' value='Update'/>
    </form>
</div>

<div>
    <form action='signout' method='POST'>
        <input name="email" type="text" value="<%= ((User)request.getAttribute("user")).getEmail() %>" hidden>
        <input type='submit' value='Sign Out'/>
    </form>
</div>
</body>
</html>