import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class VisitCounterServlet extends HttpServlet 
{
    private int visitCount;
    public void init() 
    {
        // Initialize the visit count to 0
        visitCount = 0;
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    // Get the current visit count from the cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) 
        {
            for (Cookie cookie : cookies) 
            {
                if (cookie.getName().equals("visitCount")) 
                {
                    visitCount = Integer.parseInt(cookie.getValue());
                }
            }
        }
        // Increment the visit count
        visitCount++;
        // Store the updated visit count in a new cookie
        Cookie visitCountCookie = new Cookie("visitCount", Integer.toString(visitCount));
        visitCountCookie.setMaxAge(60 * 60 * 24 * 365); // Cookie lasts for one year
        response.addCookie(visitCountCookie);
        // Send the response with the updated visit count
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>You have visited this servlet " + visitCount + "times</h2>");
        out.println("</body></html>");
    }
}
