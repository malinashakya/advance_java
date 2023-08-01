package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class addstudent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <form methoid=\"get\" action=\"#\">\n");
      out.write("        <input type=\"number\" name=\"id\" placeholder=\"Enter id\" required/><br/>\n");
      out.write("        <input type=\"text\" name=\"name\" placeholder=\"Enter name\" required/><br/>\n");
      out.write("        <input type=\"text\" name=\"address\" placeholder=\"Enter address\" required/><br/>\n");
      out.write("        <select name=\"faculty\" placeholder=\"Choose faculty\">\n");
      out.write("            <option value=\"BIM\">\n");
      out.write("                BIM\n");
      out.write("            </option>\n");
      out.write("            <option value=\"BCA\">\n");
      out.write("                BCA\n");
      out.write("            </option>\n");
      out.write("            <option value=\"CSIT\">\n");
      out.write("                CSIT\n");
      out.write("            </option>\n");
      out.write("            <option value=\"BBA\">\n");
      out.write("                BBA\n");
      out.write("            </option>\n");
      out.write("        </select>\n");
      out.write("        <input type=\"submit\" name=\"submit\" value=\"submit\"/>\n");
      out.write("        </form>\n");
      out.write("        ");

            String url="jdbc:mysql://localhost:3306/studentdetail";
            String uname="root";
            String pwd="";
            if(request.getParameter("submit")!=null)
            {
                int id=Integer.parseInt(request.getParameter("id"));
                String name=request.getParameter("name");
                String address=request.getParameter("address");
                String faculty=request.getParameter("faculty");
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection(url,uname,pwd);
                    String sql="insert into student(id, name, address, faculty) values (?,?,?,?)";
                    PreparedStatement st=con.prepareStatement(sql);
                    st.setInt(1,id);
                    st.setString(2,name);
                    st.setString(3,address);
                    st.setString(4,faculty);
                    st.execute();
                    con.close();
                }
                catch(Exception e)
                {
                    out.println(e);
                }
            }
            
      out.write("\n");
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
