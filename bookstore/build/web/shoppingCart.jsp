<%-- 
    Document   : shopping_cart
    Created on : 10.12.2012, 21:38:25
    Author     : Alex
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                <a href=booklist >Click to view booklist</a>|
                <a href="signIn.jsp" >signIn</a>|
                <a href="registration.jsp" >registration</a>|
                <a href="sessiondestroy" >logout</a>
                <a href="ViewShoppingCart" >shopping cart</a>
                <a href=ExpectingBookList >Coming soon</a>
            </div>
            <div class="main_page_text">


                <center>

                    <table border="1">
                        <tr>
                            <th>Name </th>
                            <th>Author </th>
                            <th>Genre </th>
                            <th>Year </th>
                            <th>Amount</th>
                            <th>ID</th>


                        </tr>
                        <c:forEach var="book" items="${shoppingList}"> 
                            <tr>
                                <td>${book.bookName} </td>
                                <td>${book.bookAuthor} </td>
                                <td>${book.bookGenre} </td>
                                <td>${book.bookYear} </td>
                                <td>${book.bookAmount}</td>
                                <td>${book.bookId}</td>


                            </tr>
                        </c:forEach> 

                    </table>

                </center>

                <form name="confirmform" action="ConfirmOrder">
                    <input type="submit" value="confirm" name="confirmbutton" />

                </form>



            </div>
            <div class="bottom_text"> &nbsp
            </div>      </div>
    </body>
</html>
