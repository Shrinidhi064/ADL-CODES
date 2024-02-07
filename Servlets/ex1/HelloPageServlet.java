import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HelloPageServlet")
public class HelloPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve name and start time from session
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        Instant startTime = (Instant) session.getAttribute("startTime");

        // Calculate duration
        Instant endTime = Instant.now();
        long durationSeconds = Duration.between(startTime, endTime).getSeconds();

        // Generate HTML response
        String helloPage = "<!DOCTYPE html>" +
                            "<html>" +
                            "<head>" +
                            "<meta charset=\"UTF-8\">" +
                            "<title>Hello Page</title>" +
                            "<style> .top-right { position: absolute; top: 10px; right: 10px; } </style>" +
                            "</head>" +
                            "<body>" +
                            "<h2>Hello " + name + "</h2>" +
                            "<div class=\"top-right\">Start Time: " + startTime + "</div>" +
                            "<form action=\"LogoutServlet\" method=\"post\">" +
                            "<input type=\"submit\" value=\"Logout\">" +
                            "</form>" +
                            "</body>" +
                            "</html>";

        // Send response
        response.setContentType("text/html");
        response.getWriter().write(helloPage);
    }
}
