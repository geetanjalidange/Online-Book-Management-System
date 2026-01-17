import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String title = req.getParameter("title");
        String author = req.getParameter("author");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/book_db","root","root");

            PreparedStatement ps =
              con.prepareStatement("INSERT INTO books(title,author) VALUES(?,?)");
            ps.setString(1, title);
            ps.setString(2, author);
            ps.executeUpdate();

            res.sendRedirect("viewBooks.jsp");
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
