import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve name and start time from session
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        Instant startTime = (Instant) session.getAttribute("startTime");

        // Calculate duration
        Instant endTime = Instant.now();
        long durationSeconds = Duration.between(startTime, endTime).getSeconds();

        // Generate HTML response for logout page
        String logoutPage = "<!DOCTYPE html>" +
                            "<html>" +
                            "<head>" +
                            "<meta charset=\"UTF-8\">" +
                            "<title>Logout Page</title>" +
                            "</head>" +
                            "<body>" +
                            "<h2>Thank You " + name + "</h2>" +
                            "<p>Duration of usage: " + durationSeconds + " seconds</p>" +
                            "</body>" +
                            "</html>";

        // Invalidate session
        session.invalidate();

        // Send response
        response.setContentType("text/html");
        response.getWriter().write(logoutPage);
    }
}
