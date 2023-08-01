import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.*;
@WebServlet("/validate")
public class validate_user_servlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html");
        //set database parameters
        String url="jdbc:mysql://localhost:3306/javadatass";
        String uname="root";
        String pswd="";
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        try{
            PrintWriter pw=response.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,uname,pswd);
            String sql="select * from login where username=? and password=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,username);
            st.setString(2,password);
            ResultSet rs=st.executeQuery();
            if(rs.next())
            {
                //valid user
                HttpSession session=request.getSession();
                session.setAttribute("username",username);
                session.setMaxInactiveInterval(60*60);
                response.sendRedirect("home");
            }
            else
            {
                //invalid user
                pw.println("<h3>Incorrect user details</h3>");
                RequestDispatcher rd=request.getRequestDispatcher("loginpage.html");
                rd.include(request,response);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}