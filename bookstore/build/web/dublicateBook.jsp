<%-- 
    Document   : dublicateBook
    Created on : 20.12.2012, 20:40:53
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head> 
    <title>Dublicate book</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
	<script src="countdownRedirect.js" type="text/javascript"></script> 
</head> 
<body onload='countdownRedirect("addBook.jsp", "Redirecting...")'> 
<center><h1>There is a book with such name already! Check book name or contact warehouse admin</h1> 
<strong><a href="addBook.jsp">"Try again"</a></strong><p> 
<strong>You'll be redirec in <span class="counter" id="COUNTDOWN_REDIRECT">3</span> sec.</strong> 
</p> 
</body> 
</html>
