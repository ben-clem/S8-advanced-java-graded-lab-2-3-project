<%@ page import="java.util.Date" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="model.entitity.User" %>
<%@ page import="model.entitity.Property" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
</head>

<body>
<h1><%= "Success!" %>
</h1>
<h4><%= ((User) request.getAttribute("user")).toString() %>
</h4>
<h4>
    <%
        try {
            List<Property> properties = ((List<Property>) request.getAttribute("properties"));
    %><p>properties:
    <p><% int i = 0;
    for (Property property : properties) {
%><p>n° <%= i %>:
    <p>
            <%=(property.toString())%>
            <% i++;
        }
    } catch (Exception e) { %>
    <p>errors:
    <p><%=(e.toString())%>
            <%
    }
%>
</h4>
<div>
    <form action='update' method='POST'>
        <input name="key" type="text" value="key">
        <input name="value" type="text" value="value">
        <input name="type" type="text" value="add" hidden>
        <input name="email" type="text" value="<%= ((User)request.getAttribute("user")).getEmail() %>" hidden>
        <input type='submit' value='Add property'/>
    </form>
</div>
<div>
    <form action='update' method='POST'>
        <input name="n°" type="text" value="n°">
        <input name="type" type="text" value="delete" hidden>
        <input name="email" type="text" value="<%= ((User)request.getAttribute("user")).getEmail() %>" hidden>
        <input type='submit' value='Delete property'/>
    </form>
</div>
<br>

<div>
    <form action='signout' method='POST'>
        <input name="email" type="text" value="<%= ((User)request.getAttribute("user")).getEmail() %>" hidden>
        <input type='submit' value='Sign Out'/>
    </form>
</div>
</body>
</html>