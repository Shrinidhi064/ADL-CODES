import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/calculator")

public class Calculator extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        // Set the content type of the response
        response.setContentType("text/html");
        // Get the user inputs for calculation
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        String op = request.getParameter("op");
        // Calculate the result based on the operator
        int result = 0;
        switch (op) {
        case "+":
        result = num1 + num2;
        break;
        case "-":
        result = num1 - num2;
        break;
        case "*":
        result = num1 * num2;
        break;
        case "/":
        result = num1 / num2;
        break;
        }
        // Generate the HTML response with the result
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Calculator Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Calculator Servlet</h2>");
        out.println("<p>Result: " + result + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
