/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookAction;

import com.mysql.jdbc.Statement;
import helljava.listElement;
import java.io.IOException;
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
 * @author Alex
 */
public class BookFind extends HttpServlet {

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
            throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        search(request, response);

    }
// Пошук заданої книги

    public void search(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException {
        HttpSession session = request.getSession();
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, loginDb, passwordDb);
        //  Connected to DB
        Statement statement = (Statement) conn.createStatement();  // создаем оператор

        try {
            ResultSet rs = statement.executeQuery("SELECT id_book, name, author,"
                    + " genre, year, amount, price, rate from book_shop.book where name like '%" + request.getParameter("bookNameSearch") + "%' or author like '%" + request.getParameter("bookNameSearch") + "%'");
            findBookList = new ArrayList<listElement>();
            while (rs.next()) {
                listElement element = new listElement();
                element.setBookId(rs.getInt("id_book"));
                element.setBookName(rs.getString("name"));
                element.setBookAuthor(rs.getString("author"));
                element.setBookGenre(rs.getString("genre"));
                element.setBookYear(rs.getInt("year"));
                element.setBookAmount(rs.getInt("amount"));
                element.setBookPrice(rs.getInt("price"));
                element.setBookRate(rs.getInt("rate"));
                findBookList.add(element);


            }

            session.setAttribute("FindBookList", findBookList);
            statement.close();
            conn.close();
            response.sendRedirect("searchResult.jsp");
        } finally {
            statement.close();
            conn.close();
        }


    }
    ArrayList<listElement> findBookList;
    private Connection conn = null;
    private String loginDb = "root";
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
        } catch (InstantiationException ex) {
            Logger.getLogger(BookFind.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BookFind.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookFind.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookFind.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BookFind.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BookFind.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookFind.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookFind.class.getName()).log(Level.SEVERE, null, ex);
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
