package com;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet(&quot;/testa&quot;)
public class testa extends HttpServlet{
public testa()
{
super();
}

protected void doGet(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
}
protected void doPost(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
response.setContentType(&quot;text/html&quot;);
PrintWriter out = response.getWriter();
out.println(&quot;&lt;!DOCTYPE html&gt;\n&quot; +
&quot;&lt;html lang=\&quot;en\&quot;&gt;\n&quot; +
&quot;&lt;head&gt;\n&quot; +
&quot; &lt;meta charset=\&quot;UTF-8\&quot;&gt;\n&quot; +
&quot; &lt;meta name=\&quot;viewport\&quot; content=\&quot;width=device-width,
initial-scale=1.0\&quot;&gt;\n&quot; +
&quot; &lt;title&gt;Home&lt;/title&gt;\n&quot; +
&quot; &lt;style&gt;\n&quot; +
&quot; body{\n&quot; +
&quot; margin: 0;\n&quot; +
&quot; padding: 0;\n&quot; +
&quot; height: 100vh;\n&quot; +
&quot; display: flex;\n&quot; +
&quot; justify-content: center;\n&quot; +
&quot; align-items: center;\n&quot; +
&quot;\n&quot; +
&quot; }\n&quot; +
&quot; &lt;/style&gt;\n&quot; +
&quot;&lt;/head&gt;\n&quot; +
&quot;&lt;body&gt;&quot;);
try {
String username= request.getParameter(&quot;username&quot;);
String password=request.getParameter(&quot;password&quot;);
Class.forName(&quot;com.mysql.jdbc.Driver&quot;);
Connection conn =
DriverManager.getConnection(&quot;jdbc:mysql://localhost:3306/login&quot;, &quot;root&quot;,
&quot;root&quot;);
Statement st=conn.createStatement();
ResultSet r=st.executeQuery(String.format( &quot;select * from
credentials where username=&#39;%s&#39; and password=&#39;%s&#39; &quot;,username,password));
if (r.next())
{
out.println(&quot;&lt;h2&gt;Login Successful&lt;/h2&gt;&quot;);
}
else {
out.println(&quot;&lt;h2&gt;Login Failed! Invalid Username or
Password&lt;/h2&gt;&quot;);
}
out.println(&quot;&lt;/body&gt;&lt;/html&gt;&quot;);
}
catch (Exception e)
{
System.out.println(e.getMessage());
}
}
}