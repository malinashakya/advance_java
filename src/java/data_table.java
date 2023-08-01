import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
@WebServlet("/view")
public class data_table extends HttpServlet{
  protected void doGet(HttpServletRequest resquest, HttpServletResponse response)
    {
            String url="jdbc:mysql://localhost:3306/javadatass";
         String uname="root";
        String pswd="";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,uname,pswd);
            String sql="select * from student";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs=st.executeQuery(sql);
            PrintWriter out=response.getWriter();
            out.println("<html><body><table border='1' width='600' align='center'>");
            out.println("<tr><th>Id</th><th>Name</th><th>Address</th><th>Faculty</th></tr>");
            while(rs.next())
            {
                out.println("<tr>");
                out.println("<td>"+rs.getString("id")+"</td>");
                out.println("<td>"+rs.getString("name")+"</td>");
                out.println("<td>"+rs.getString("address")+"</td>");
                out.println("<td>"+rs.getString("faculty")+"</td>");
                out.println("</tr>");
            }
            con.close();
            out.println("</table></body></html>");
            out.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}