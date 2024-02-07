import java.io.IOException;
import java.time.Instant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get name from the request
        String name = request.getParameter("name");

        // Create or retrieve session
        HttpSession session = request.getSession();

        // Store name and start time in session
        session.setAttribute("name", name);
        session.setAttribute("startTime", Instant.now());

        // Redirect to Hello page
        response.sendRedirect("HelloPageServlet");
    }
}
