package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class viewstudent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table border=\"1\" width=\"600\" align=\"center\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Id</th>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th>Address</th>\n");
      out.write("                <th>Faculty</th>\n");
      out.write("                <th>Update</th>\n");
      out.write("                <th>Delete</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                int start=0,recordcount=2,total=0;
                String url = "jdbc:mysql://localhost:3306/studentdetail";
                String uname = "root";
                String pwd = "";

                try {
                    int pgno=request.getParameter("pgno")==null?0: Integer.parseInt(request.getParameter("pgno"));
                    start=pgno*recordcount;
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, uname, pwd);
                    String sql = "select * from student limit ?,?";
                    PreparedStatement st = con.prepareStatement(sql);
                    st.setInt(1,start);
                    st.setInt(2,recordcount);
                    ResultSet rs = st.executeQuery();

                    while (rs.next()) {
                        int a = Integer.parseInt(rs.getString("id"));
            
      out.write("\n");
      out.write("            <tr><td>");
 out.println(rs.getString("id")); 
      out.write("</td><td>");
 out.println(rs.getString("name")); 
      out.write("</td>\n");
      out.write("                <td>");
 out.println(rs.getString("address")); 
      out.write("</td><td>");
 out.println(rs.getString("faculty"));
      out.write("</td>   \n");
      out.write("                <td><a href='update.jsp?id=");
      out.print(rs.getString("id"));
      out.write("&name=");
      out.print(rs.getString("name"));
      out.write("\n");
      out.write("                       &address=");
      out.print(rs.getString("address"));
      out.write("&faculty=");
      out.print(rs.getString("faculty"));
      out.write("'>Update</a></td>\n");
      out.write("                <td><a href='delete.jsp?id=");
      out.print(rs.getString("id"));
      out.write("' onclick=\"return confirm('Are you sure?')\" >Delete</a></td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                    }
                    String sql1 = "select count(*) from student";
                    PreparedStatement st1 = con.prepareStatement(sql1);
                    ResultSet rs1 = st1.executeQuery();
                    if (rs1.next()) {
                        total = rs1.getInt(1);
                    }
                    con.close();
                } catch (Exception e) {
                    out.println(e);
                }

            
      out.write("\n");
      out.write("        </table>\n");
      out.write("    <center>\n");
      out.write("        ");

            for(int i=0;i<total/recordcount;i++)
            {
      out.write("\n");
      out.write("            <a href=\"viewstudent.jsp?pgno=");
      out.print(i);
      out.write("\">Page");
      out.print(i+1);
      out.write("</a>\n");
      out.write("            ");
}
        
      out.write("\n");
      out.write("    </center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
