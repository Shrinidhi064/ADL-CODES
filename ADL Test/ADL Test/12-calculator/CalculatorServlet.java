import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CalculatorServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throwsServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Servlet
        CalculatorServlet</title></head><body>");
        double n1 = Double.parseDouble(request.getParameter("txtN1"));
        double n2 = Double.parseDouble(request.getParameter("txtN2"));
        double result =0;
        String opr=request.getParameter("opr");
        if(opr.equals("+"))
        result=n1+n2;
        if(opr.equals("*"))
        result=n1*n2;
        out.println("<h1> Result = "+result);
        if(opr.equals("-"))
        result=n1-n2;
        if(opr.equals("/"))
        result=n1/n2;
        out.println("</body></html>");
    } 
}
