/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import helljava.listElement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alex
 */
public class AddToShoppingCart extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {


        HttpSession session = request.getSession();
        if ((session.getAttribute("authorization") == null)) {

            response.sendRedirect("signIn.jsp");

        } else {



            response.setContentType("text/html;charset=UTF-8");
            addBookToCart(request, response);
        }
    }
    
// Додаємо книгу в кошик користувача
    public void addBookToCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        HttpSession session = request.getSession();
        listElement bookToCart;
        bookToCart = (listElement) session.getAttribute("bookProp");
        int bookId = bookToCart.getBookId();
        //****************************************************************** CHECK IT
        if (session.getAttribute("theId") != null) {


            int userId = (Integer) session.getAttribute("theId");
            int amount = Integer.parseInt(request.getParameter("amount"));

            //System.out.println("asdasdas"+bookId);

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, loginDb, passwordDb);
            Statement statement = conn.createStatement();
            try {
                statement.executeUpdate("INSERT INTO book_shop.orders (o_book_id, o_user_id, o_amount) "
                        + "VALUES('" + bookId + "', '" + userId + "', '" + amount + "')");
                statement.close();
                conn.close();
            } finally {
                statement.close();
                conn.close();
            }
            response.sendRedirect("booklist.jsp");
        } else {
            response.sendRedirect("signIn.jsp");
        }


    }
    private String loginDb = "root";
    private Connection conn = null;
    private String passwordDb = "qwe321";
    private String url = "jdbc:mysql://localhost/";

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddToShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddToShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AddToShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AddToShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddToShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddToShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AddToShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AddToShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
