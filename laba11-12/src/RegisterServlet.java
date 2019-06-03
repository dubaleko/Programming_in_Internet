import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String retry = request.getParameter("retry");

            if (username != "" && password != "" && retry.equals(password)) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(LoginServlet.url, LoginServlet.name, LoginServlet.password);
                Statement statement =  connection.createStatement();
                String sqlCommand = "insert into login_tools VALUES('"+username+"', '"+password+"')";
                statement.executeUpdate(sqlCommand);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Insert valid data in fields");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            request.setAttribute("message", e.getMessage());
            request.setAttribute("error", e.getClass());
            request.getRequestDispatcher("/WEB-INF/Views/ErrorPage.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("message", e.getMessage());
            request.setAttribute("error", e.getClass());
            request.getRequestDispatcher("/WEB-INF/Views/ErrorPage.jsp").forward(request, response);
        }
    }
}