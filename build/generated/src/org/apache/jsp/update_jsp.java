package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <body>\n");
      out.write("    <form method=\"get\" action=\"#\">\n");
      out.write("    <input type=\"text\" name=\"id\" value=");
      out.print(request.getParameter("id"));
      out.write(" readonly required/><br/>\n");
      out.write("    <input type=\"text\" name=\"name\" value=");
      out.print(request.getParameter("name"));
      out.write("  required/><br/>\n");
      out.write("    <input type=\"text\" name=\"address\" value=");
      out.print(request.getParameter("address"));
      out.write("  required/><br/>\n");
      out.write("    <input type=\"text\" name=\"faculty\" value=");
      out.print(request.getParameter("faculty"));
      out.write("  required/><br/>\n");
      out.write("    <input type=\"submit\" value=\"Update\" name=\"submit\"/><br/>\n");
      out.write("    </form>\n");
      out.write("         ");

            String url="jdbc:mysql://localhost:3306/studentdetail";
            String uname="root";
            String pwd="";
        
                int id=Integer.parseInt(request.getParameter("id"));
                String name=request.getParameter("name");
                String address=request.getParameter("address");
                String faculty=request.getParameter("faculty");
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection(url,uname,pwd);
                    String sql="update student set id=?,name=?,address=?,faculty=? where id=?";
                    PreparedStatement st=con.prepareStatement(sql);
                    st.setInt(1,id);
                     st.setString(2,name);
                    st.setString(3,address);
                    st.setString(4,faculty);
                    st.setInt(5,id);
                    st.execute();
                    con.close();
                    response.sendRedirect("viewstudent.jsp");
                }
                catch(Exception e)
                {
                    out.println(e);
                }
       
            
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
