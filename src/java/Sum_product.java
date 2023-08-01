import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.annotation.*;
@WebServlet("/parama")
public class Sum_product extends HttpServlet{
protected void doGet(HttpServletRequest request,HttpServletResponse response){
    response.setContentType("text/html");
    int n1=Integer.parseInt(request.getParameter("name1"));
      int n2=Integer.parseInt(request.getParameter("name2"));
      
    try{
        PrintWriter out=response.getWriter();
        int sum, product;
        sum=n1+n2;
        product=n1*n2;
        out.print("<h1>Sum: "+sum+"<h1>");
        out.print("<h1>Product: "+product+"<h1>");
        RequestDispatcher rd=request.getRequestDispatcher("sum_product.html");
                rd.include(request,response);
                out.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}
}