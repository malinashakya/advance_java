import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;
@WebServlet("/param")
public class ParamServlet extends HttpServlet{
protected void doGet(HttpServletRequest request,HttpServletResponse response){
    response.setContentType("text/html");
    String n=request.getParameter("name");
    try{
        PrintWriter out=response.getWriter();
        out.println("<h1>Hello "+n+"</h1>");
        out.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}
}