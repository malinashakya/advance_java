import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.*;
@WebServlet("/home")
public class homeservlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html");
        HttpSession session=request.getSession();
        Object value=session.getAttribute("username");
        try
        {
            PrintWriter pw=response.getWriter();
            if(value==null)
            {
                response.sendRedirect("loginpage.html");
            }
            else
                    {
                        pw.println("<h3>Welcome"+value+"</h3>");
                        pw.println("<a href='logoutpage'>Logout</a>");
                    }
            pw.close();
            }
         
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}