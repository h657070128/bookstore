package helljava;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mysql.jdbc.Statement;
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
 * @author alex
 */
public class booklist extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        route = (String) session.getAttribute("route");
        if (route == null) {
            route = "";
        }
        if (request.getParameter("bookId") != null) {



            if ((session.getAttribute("authorization") == null)) {

                response.sendRedirect("signIn.jsp");

            } else {


                try {
                    viewBook(request, response);


                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(booklist.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(booklist.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(booklist.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(booklist.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else {







            try {
                /* TODO output your page here. You may use following sample code. */
                listBooks(request);
            } catch (SQLException ex) {
                Logger.getLogger(booklist.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(booklist.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(booklist.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(booklist.class.getName()).log(Level.SEVERE, null, ex);
            }




            session.setAttribute("registrations", rayList);
            session.setAttribute("helljsp", rayList.get(0).getBookName());
            response.sendRedirect("" + route + "booklist.jsp");
        }

    }
//***************** Selected book view

    public void viewBook(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, loginDb, passwordDb);
        Statement statement = (Statement) conn.createStatement();
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        try {
            ResultSet rs = statement.executeQuery("SELECT id_book, name, author,"
                    + " genre, year, amount, price, rate from book_shop.book where id_book='" + bookId + "'");
            rs.next();
            listElement viewBookelement = new listElement();

            viewBookelement.setBookId(rs.getInt("id_book"));
            viewBookelement.setBookName(rs.getString("name"));
            viewBookelement.setBookAuthor(rs.getString("author"));
            viewBookelement.setBookGenre(rs.getString("genre"));
            viewBookelement.setBookAmount(rs.getInt("amount"));
            viewBookelement.setBookYear(rs.getInt("year"));
            viewBookelement.setBookPrice(rs.getInt("price"));
            viewBookelement.setBookRate(rs.getInt("rate"));
            conn.close();
            statement.close();
            HttpSession session = request.getSession();
            String route = (String) session.getAttribute("route");
            session.setAttribute("bookProp", viewBookelement);
            int check = (Integer) session.getAttribute("authorization");
            if (check == 0) {
                response.sendRedirect("viewBook.jsp");
            } else {

                response.sendRedirect("" + route + "veiwBook.jsp");
            }
        } finally {
            conn.close();
            statement.close();
        }

    }

//************* Creating list of al books (raylist)
    public void listBooks(HttpServletRequest request) throws SQLException,
            InstantiationException, IllegalAccessException, ClassNotFoundException,
            IOException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, loginDb, passwordDb);
        //  Connected to DB
        String sort = "name";


        sort = request.getParameter("sort");
        if (sort == null || sort.equals("rate")) {
            sort = "rate desc";
        }
        if (sort.equals("year")) {
            sort = "year desc";
        }
        if (sort.equals("genre")) {

            sort = "genre, rate desc";

        }
        Statement statement = (Statement) conn.createStatement();  // создаем оператор
        try {
            ResultSet rs = statement.executeQuery("SELECT id_book, name, author, genre,"
                    + " year, amount, price, rate, deleted from book_shop.book where deleted!='1' order by " + sort + "");
            rayList = new ArrayList<listElement>();
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
                rayList.add(element);


            }


            conn.close();
            statement.close();
        } finally {

            conn.close();
            statement.close();
        }

    }
    private String route = "";
    ArrayList<listElement> rayList;
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
        processRequest(request, response);
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
        processRequest(request, response);
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
