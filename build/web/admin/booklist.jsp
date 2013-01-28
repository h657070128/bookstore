<%-- 
    Document   : newjsp
    Created on : 20.12.2012, 23:49:52
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="helljava.listElement" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booklist</title>
        <link rel="stylesheet" media="screen" type="text/css" href="../form_sign_in_style.css" />
    </head>
    <body>
        <div class="main_part_page">
            <div class="top_page_text">
                <form action="../BookFind">
                    <input type="text" name="bookNameSearch" />

                    <input type="submit" value="search" name="a" />
                    
                    <div style="float: right;"> You logged as ${theName}   
 </div>
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

                <h4>   We have <%= ((java.util.ArrayList) session.getAttribute("registrations")).size()%> books!!!</h4>





                <center>   <table border="1" >
                        <tr>
                            <th>Name </th>
                            <th>Author </th>
                            <th>Genre </th>
                            <th>Year </th>
                            <th>Amount</th>
                            <th>ID</th>
                            <th>Rate</th>
                            <th>Edit book</th>
                        </tr>
                        <c:forEach var="book" items="${registrations}"> 
                            <tr>
                                <td>${book.bookName} </td>
                                <td>${book.bookAuthor} </td>
                                <td>${book.bookGenre} </td>
                                <td>${book.bookYear} </td>
                                <td>${book.bookAmount}</td>
                                <td>${book.bookId}</td>
                                <td>${book.bookRate}</td>
                                <td><a href="../booklist?bookId=${book.bookId}" >View</a></td>
                            </tr>
                        </c:forEach> 

                    </table>
                </center>
                <form action="addBook.jsp">
                    <input type="submit" value="add book" name="add book" />

                </form>
                <form action="../booklist"><select name="sort">
                        <option>name</option>
                        <option>author</option>
                        <option>year</option>
                        <option>genre</option>
                        <option>rate</option>
                    </select>
                    <input type="submit" value="sort" name="2" />
                </form>

            </div>
              <div class="bottom_text"> &nbsp
            </div>
        </div>
    </body>
</html>
