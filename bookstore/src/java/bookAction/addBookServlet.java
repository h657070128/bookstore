package bookAction;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import auth.signIn;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
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
public class addBookServlet extends HttpServlet {

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
    private Connection conn = null;
    private String loginDb = "root";
    private String passwordDb = "qwe321";
    private String url = "jdbc:mysql://localhost/";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        if ((session.getAttribute("authorization") == null)) {

            response.sendRedirect("signIn.jsp");

        } else {


            abbBook(request, response);


        }
    }
// Додавання книги до списку наявних книг
    public void abbBook(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, loginDb, passwordDb);
        Statement statement = conn.createStatement();
        if (request.getParameter("name").equals("") || request.getParameter("author").equals("") || request.getParameter("genre").equals("") || request.getParameter("year").equals("") || request.getParameter("amount").equals("") || request.getParameter("price").equals("") || request.getParameter("rate").equals("")) {
            response.sendRedirect("addBook.jsp");
        } else {

            try {
                statement.executeUpdate("INSERT INTO book_shop.book (name, author, genre, year, amount, price, rate, deleted) "
                        + "VALUES('" + request.getParameter("name") + "', '"
                        + request.getParameter("author") + "', '"
                        + request.getParameter("genre") + "', '"
                        + request.getParameter("year") + "', '"
                        + request.getParameter("amount") + "', '"
                        + request.getParameter("price") + "', '"
                        + request.getParameter("rate") + "', '0')");
                response.sendRedirect("booklist");
            } catch (MySQLIntegrityConstraintViolationException ex) {
                Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("dublicateBook.jsp");
            } catch (SQLException ex) {
                Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("error_db.jsp");
            }
            finally { conn.close();
            statement.close();}
           
        }
    }

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
            Logger.getLogger(addBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(addBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addBookServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(addBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(addBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addBookServlet.class.getName()).log(Level.SEVERE, null, ex);
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
