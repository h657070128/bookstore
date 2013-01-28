<%-- 
    Document   : fillInError
    Created on : 21.12.2012, 3:01:30
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <head> 
        <title>Fill in all fields, please</title> 
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
        <script src="countdownRedirect.js" type="text/javascript"></script> 
    </head> 
    <body onload='countdownRedirect("registration.jsp", "Redirecting...")'> 
    <center><h1>All fields are required. Please fill in all fields!</h1> 
        <strong><a href="signIn.jsp">"Try again"</a></strong><p> 
            <strong>You'll be redirec in <span class="counter" id="COUNTDOWN_REDIRECT">3</span> sec.</strong> 
        </p> 
    </body> 
</html>