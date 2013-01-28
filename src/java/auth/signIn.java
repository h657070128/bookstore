package auth;

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
public class signIn extends HttpServlet {

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
            throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        authorization(request, response);

    }

    public int hashCheck(String password) {

        return password.hashCode();
    }

    // Занесення параметрів користувача у сессію
    public void sessionAdd(HttpServletRequest req, HttpServletResponse resp, String name, int id, int role) {
        HttpSession session = req.getSession(true);
        session.setAttribute("theName", name);
        session.setAttribute("theId", id);
        session.setAttribute("authorization", role);
        session.setAttribute("route", route);

    }

    // Авторизація, перевірка логіну та паролю.
  
    public void authorization(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {

     

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, loginDb, passwordDb);
            //  Connected to DB
            Statement statement = (Statement) conn.createStatement();  // создаем оператор
        try {       loginUser = req.getParameter("login");
            passwordUser = req.getParameter("password");
            ResultSet rs = statement.executeQuery("SELECT password , iduser, root from book_shop.user where username='" + loginUser + "'"); // запрос проверки пароля
            String g = "";
            int x = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                g = rs.getString("password");
                idUser = rs.getInt("iduser");
                role = rs.getInt("root");
            }
            if (passwordUser.equals(g)) {  // PASSWORD CORRECT

                // 0 - simple user
                // 7 - Admin
                if (role == 7) {
                    route = "admin/";
                } else {
                    route = "";
                }
                sessionAdd(req, resp, loginUser, idUser, role);

                resp.sendRedirect("index.jsp");
            } else {
                resp.sendRedirect("signIn.jsp");  // PASSWORD INCORRECT
            }
        } catch (Exception e) {
            Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, e);
            resp.sendRedirect("error_db.jsp");
        } finally {
           
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
        conn.close();
        statement.close();
            }
        }

    }
    private String route = "";
    private int role;
    private int idUser;
    private String loginUser = "";
    private String passwordUser = "";
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
                    try {
                        processRequest(request, response);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
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
                    try {
                        processRequest(request, response);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
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
