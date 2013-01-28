<%-- 
    Document   : viewBookUser
    Created on : 19.12.2012, 3:01:53
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" media="screen" type="text/css" href="form_sign_in_style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                ID: ${bookProp.bookId}
                Name: ${bookProp.bookName}<br>
                Author: ${bookProp.bookAuthor} <br>
                Genre: ${bookProp.bookGenre} <br>
                Year: ${bookProp.bookYear} <br>
                Amount: ${bookProp.bookAmount} <br>
                Price: ${bookProp.bookPrice}<br>
                Rate: ${bookProp.bookRate}<br>
                main page text


                <form name="addBook" action="AddToShoppingCart">

                    <input type="submit" value="add book to shoping cart" name="a" />
                    <input type="text" name="amount" value="1" size="2" />


                </form>
            </div>
            <div class="bottom_text"> &nbsp
            </div>    </div>
    </body>
</html>
