import java.io.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/usecookie")
public class use_cookie extends HttpServlet{
protected void doGet(HttpServletRequest request, HttpServletResponse response)
{
response.setContentType("text/html");
Cookie c1=new Cookie("username","password");
c1.setMaxAge(24*60*60);
response.addCookie(c1);
Cookie ck[]=request.getCookies();
try{
    PrintWriter out=response.getWriter();
    for(Cookie c:ck)
    {
        out.println("Cookie name:"+c.getName());
        out.println("Cookie value:"+c.getValue());
    }
    out.close();
}
catch(Exception e)
{
    e.printStackTrace();
}
}
}
