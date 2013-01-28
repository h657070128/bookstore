<%-- 
    Document   : registration
    Created on : 17.11.2012, 18:58:18
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" media="screen" type="text/css" href="form_sign_in_style.css" />
    </head><body>


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
                <br> 
                <br> 
                <center>       
                    <form class="form-container" method=get action="registration" >
                        <div class="form-title"><h2>Register New User</h2></div>
                        <div class="form-title">Login</div>
                        <input class="form-field" type="text" name="login" /><br />
                        <div class="form-title">Password</div>
                        <input class="form-field" type="password" name="password" maxlength="10"/><br />
                        <div class="form-title">Your name</div>
                        <input class="form-field" type="text" name="name" /><br />
                        <div class="form-title">email</div>
                        <input class="form-field" type="text" name="email" /><br />
                        <div class="submit-container">
                            <input class="submit-button" type="submit" value="Sign in" />
                        </div>

                    </form> </center>
            </div>
            <div class="bottom_text"> &nbsp
            </div>
        </div>


    </body>
</html>
