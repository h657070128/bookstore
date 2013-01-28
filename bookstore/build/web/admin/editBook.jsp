<%-- 
    Document   : editBook
    Created on : 08.12.2012, 0:46:01
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

                <center>           <form name="name" action="../bookEditSave" method=get>
                        ID</br>
                        <input type="text" name="id_book" value=${bookProp.bookId} readonly />  </br>
                        name </br>
                        <input type="text" name="name" value="${bookProp.bookName}" />  </br>
                        author </br>  
                        <input type="text" name="author" value="${bookProp.bookAuthor}" /></br>
                        genre </br>
                        <input type="text" name="genre" value="${bookProp.bookGenre}" /> </br>
                        year </br>
                        <input type="text" name="year" value=${bookProp.bookYear} onkeypress='validate(event)' /></br>
                        amount </br>
                        <input type="text" name="amount" value=${bookProp.bookAmount} onkeypress='validate(event)' /></br>
                        price </br>
                        <input type="text" name="price" value=${bookProp.bookPrice} onkeypress='validate(event)' /> </br>
                        rate </br>
                        <input type="text" name="rate" value=${bookProp.bookRate} onkeypress='validate(event)' /> </br>

                        <input type="submit" value="save" name="sub" />
                    </form>

                </center>
          <div class="bottom_text"> &nbsp
            </div>    </div>
        </div>

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