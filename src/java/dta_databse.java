import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
@WebServlet("/param1")
public class dta_databse extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html");
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String address=request.getParameter("address");
        String faculty=request.getParameter("faculty");
        String url="jdbc:mysql://localhost:3306/javadatass";
        String uname="root";
        String pswd="";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,uname,pswd);
            String sql="insert into student(id,name,address,faculty) values (?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2,name);
            st.setString(3,address);
            st.setString(4,faculty);
            st.execute();
            con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        try{
            PrintWriter out=response.getWriter();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}