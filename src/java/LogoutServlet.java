import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.*;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html");
        HttpSession session=request.getSession();
       session.invalidate();
            try{
                response.sendRedirect("loginpage.html");
            }
         
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}