import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListCookiesServlet")
public class ListCookiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get all cookies from the request
        Cookie[] cookies = request.getCookies();

        // Prepare response content
        StringBuilder responseContent = new StringBuilder();
        responseContent.append("<h2>List of Cookies:</h2>");

        if (cookies != null && cookies.length > 0) {
            responseContent.append("<ul>");
            for (Cookie cookie : cookies) {
                responseContent.append("<li>").append(cookie.getName()).append(": ").append(cookie.getValue()).append("</li>");
            }
            responseContent.append("</ul>");
        } else {
            responseContent.append("<p>No cookies found.</p>");
        }

        // Send response
        response.setContentType("text/html");
        response.getWriter().write(responseContent.toString());
    }
}
