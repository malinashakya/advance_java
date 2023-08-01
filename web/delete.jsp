<%-- 
    Document   : delete
    Created on : Jul 25, 2023, 11:51:18 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <body>
         <%
            String url="jdbc:mysql://localhost:3306/studentdetail";
            String uname="root";
            String pwd="";
        
                int id=Integer.parseInt(request.getParameter("id"));
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection(url,uname,pwd);
                    String sql="delete from student where id=?";
                    PreparedStatement st=con.prepareStatement(sql);
                    st.setInt(1,id);
                    st.execute();
                    con.close();
                    response.sendRedirect("viewstudent.jsp");
                }
                catch(Exception e)
                {
                    out.println(e);
                }
       
            %>
    </body>
</html>
