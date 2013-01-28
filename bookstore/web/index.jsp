<%-- 
    Document   : index
    Created on : 17.11.2012, 18:53:15
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
<meta HTTP-EQUIV="REFRESH" content="0; url=booklist">
        <title>TPPS</title>
        <link rel="stylesheet" media="screen" type="text/css" href="form_sign_in_style.css" />

    </head>
    <body>
        <div class="main_part_page">
            <div class="top_page_text">
                <form action="BookFind">
                    <input type="text" name="bookNameSearch" value="" />
                    <input type="submit" value="search" />
                </form>


            </div>
            <div class="top_page_links">
                <a href="booklist" >Click to view booklist</a>|
                <a href="signIn.jsp" >signIn</a>|
                <a href="registration.jsp" >registration</a>|
                <a href="sessiondestroy" >logout</a>
                <a href="ViewShoppingCart" >shopping cart</a>
                <a href="ExpectingBookList" >Coming soon</a>
            </div>
            <div class="main_page_text">



              <h1> welcome!</h1>

            </div>
            <div class="bottom_text"> &nbsp
            </div>
        </div>
    </body>
</html>
