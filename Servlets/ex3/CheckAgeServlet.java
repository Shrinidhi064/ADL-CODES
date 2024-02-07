import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CheckAgeServlet")
public class CheckAgeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        String message;
        if (age < 18) {
            message = "Hello " + name + ", you are not authorized to visit the site";
        } else {
            message = "Welcome " + name + " to this site";
        }

        response.setContentType("text/html");
        response.getWriter().write("<h1>" + message + "</h1>");
    }
}
