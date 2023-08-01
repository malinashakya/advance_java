import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;

@WebServlet("/session")
public class use_session extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
    {
        response.setContentType("text/html");
        HttpSession session=request.getSession();
        session.setMaxInactiveInterval(60);
        try{
            PrintWriter out=response.getWriter();
            out.println("Session ID:"+session.getId()+"<br/>");
            out.println("Creation Time:"+session.getCreationTime()+"<br/>");
            out.println("Last Access Time:"+session.getLastAccessedTime()+"<br/>");
            if(session.isNew())
                out.println("Welcome User");
            else
                out.println("Welcome Back");
            out.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}