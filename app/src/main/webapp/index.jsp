<%@ page import="java.util.Date" %>

<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h1><%= "Connexion" %>
</h1>
<h2>Today's date: <%= (new Date()) %>

</h2>
<br/>
<div>
    <form action='login' method='POST'>
        Login: <input type='text' name='email' required/>
        Password: <input type='password' name='password' required/>
        Password confirmation: <input type='password' name='passwordConfirm'/>
        <input type='submit' value='Sign-up / Sign-in'/>
    </form>
</div>
</body>
</html>