<%-- 
    Document   : addBookExp
    Created on : 19.12.2012, 12:24:09
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TPPS</title>
        <link rel="stylesheet" media="screen" type="text/css" href="../form_sign_in_style.css" />

    </head>
    <body>
        <div class="main_part_page">
            <div class="top_page_text">
                <form action="BookFind">
                    <input type="text" name="../bookNameSearch" value="" />
                    <input type="submit" value="search" />
                </form>


            </div>
            <div class="top_page_links">
                <a href="../booklist" >Click to view booklist</a>|
                <a href="../signIn.jsp" >signIn</a>|
                <a href="../registration.jsp" >registration</a>|
                <a href="../sessiondestroy" >logout</a>
                <a href="../ViewShoppingCart" >shopping cart</a>
                <a href="../ExpectingBookList" >Coming soon</a>
            </div>
            <div class="main_page_text">


                <form name="name" action="../AddExpBook">
                    name </br>
                    <input type="text" name="name" value="" />  </br>
                    author </br>  
                    <input type="text" name="author" value="" /></br>
                    genre </br>
                    <input type="text" name="genre" value="" /></br>
                    year </br>
                    <input type="text" name="year" value="" onkeypress='validate(event)' /></br>
                    amount </br>
                    <input type="text" name="amount" value="" onkeypress='validate(event)'/></br>

                    <input type="submit" value="add" name="sub" />
                </form>
            </div>
         <div class="bottom_text"> &nbsp
            </div> </div>
        <script>   function validate(evt) {
            var theEvent = evt || window.event;
            var key = theEvent.keyCode || theEvent.which;
            key = String.fromCharCode( key );
            var regex = /[0-9]|\./;
            if( !regex.test(key) ) {
                theEvent.returnValue = false;
                if(theEvent.preventDefault) theEvent.preventDefault();
            }
        } </script>
    </body>
</html>
