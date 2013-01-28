/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Statement;
import helljava.listElement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class ViewShoppingCart extends HttpServlet {

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
            throws ServletException, IOException, InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        if ((session.getAttribute("authorization") == null)) {

            response.sendRedirect("signIn.jsp");

        } else {

            showShoppingList(request, response);

        }
        // response.sendRedirect("shoppingCart.jsp");
    }
// Перегляд кошику
    public void showShoppingList(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("theId") != null) {
            int userId = (Integer) session.getAttribute("theId");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, loginDb, passwordDb);
            Statement statement = (Statement) conn.createStatement();  // создаем оператор
try{            //  ResultSet rs = statement.executeQuery("SELECT o_book_id from book_shop.orders where o_user_id='"+userId+"'");
            ResultSet rs = statement.executeQuery("SELECT user.iduser, user.username, book.id_book, book.name, book.author, book.genre, book.amount, book.year, book.price, orders.o_book_id, orders.o_user_id, orders.o_amount FROM (user INNER JOIN orders ON user.iduser = orders.o_user_id) INNER JOIN book ON orders.o_book_id = book.id_book WHERE ((orders.o_user_id)='"+userId+"') and (orders.o_deliver='0')");
            shoppingCartListArray = new ArrayList<listElement>();
            while (rs.next()) {
                listElement element = new listElement();
                element.setBookId(rs.getInt("id_book"));
                element.setBookName(rs.getString("name"));
                element.setBookAuthor(rs.getString("author"));
                element.setBookGenre(rs.getString("genre"));
                element.setBookAmount(rs.getInt("o_amount"));
                element.setBookYear(rs.getInt("year"));
                element.setBookPrice(rs.getInt("price"));
                shoppingCartListArray.add(element);
            }
            conn.close();
            session.setAttribute("shoppingList", shoppingCartListArray);
            response.sendRedirect("shoppingCart.jsp");
} finally{
statement.close();
conn.close();
}      


} else {
            response.sendRedirect("signIn.jsp");
        }
    }
    ArrayList<listElement> shoppingCartListArray;
    private String loginDb = "root";
    private Connection conn = null;
    private String passwordDb = "qwe321";
    private String url = "jdbc:mysql://localhost/book_shop";
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
        } catch (InstantiationException ex) {
            Logger.getLogger(ViewShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ViewShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (InstantiationException ex) {
            Logger.getLogger(ViewShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ViewShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
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
