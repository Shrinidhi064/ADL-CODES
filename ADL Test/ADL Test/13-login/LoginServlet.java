import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet 
{
    private String username = "myusername";
    private String password = "mypassword";
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        // Get the username and password from the request parameters
        String enteredUsername = request.getParameter("username");
        String enteredPassword = request.getParameter("password");
        // Check if the username and password are correct
        if (enteredUsername.equals(username) &&
        enteredPassword.equals(password)) 
        {
            // Login successful
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Hello " + enteredUsername + "</h2>");
            out.println("</body></html>");
        } 
        else 
        {
            // Login failed
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Login failed</h2>");
            out.println("</body></html>");
        }
    }
}
