import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/sign")
public class LoginServlet extends HttpServlet {

    public static  String url = "jdbc:mysql://localhost:3306/laba10";
    public static  String name ="root";
    public static  String password = "1234";
    public  static  String Name;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        ArrayList<User> list  = new ArrayList<User>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement statement =  connection.createStatement();
            String username = request.getParameter("username");
            Name = username;
            String password = request.getParameter("password");

            if (username.isEmpty() || password.isEmpty() ){
                request.setAttribute("error", "Insert valid data in fields");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            else {
                ResultSet resultSet1 = statement.executeQuery("SELECT * FROM laba10.friends where User ='" + username + "'");
                while (resultSet1.next()) {
                    list.add(new User(resultSet1.getString(1), resultSet1.getString(2), resultSet1.getString(3)));
                }

                ResultSet resultSet = statement.executeQuery("SELECT * FROM laba10.login_tools where Username ='" + username + "'");
                while (resultSet.next()) {
                    if (resultSet.getString(1).equals(username) && resultSet.getString(2).equals(password)) {
                        request.setAttribute("newusername", username);
                        request.setAttribute("date", new Date());
                        request.setAttribute("list", list);
                        this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Welcome.jsp").forward(request, response);
                    } else {
                        request.setAttribute("error", "Check you username or password");
                        request.getRequestDispatcher("Login.jsp").forward(request, response);
                    }
                }
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
