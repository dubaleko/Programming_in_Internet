import java.io.PrintWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        try
        {
            writer.println("<p>Time: " + new Date() + "</p>");
            writer.println("<p>Info about header of request:  "+ request.getHeaderNames().nextElement() + "</p>");
        }
        finally
        {
            writer.close();
        }
    }
}