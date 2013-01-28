<%-- 
    Document   : loginIsBusy
    Created on : 19.12.2012, 13:17:04
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html> 
<head> 
    <title>Login is Busy</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
	<script src="countdownRedirect.js" type="text/javascript"></script> 
</head> 
<body onload='countdownRedirect("registration.jsp", "Redirecting...")'> 
<center><h1>Sorry, this login is busy, try another one!</h1> 
<strong><a href="signIn.jsp">"Try again"</a></strong><p> 
<strong>You'll be redirec in <span class="counter" id="COUNTDOWN_REDIRECT">3</span> sec.</strong> 
</p> 
</body> 
</html>
