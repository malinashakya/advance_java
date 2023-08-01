<%-- 
    Document   : update
    Created on : Jul 25, 2023, 11:51:02 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <body>
    <form method="get" action="#">
    <input type="text" name="id" value=<%=request.getParameter("id")%> readonly required/><br/>
    <input type="text" name="name" value=<%=request.getParameter("name")%>  required/><br/>
    <input type="text" name="address" value=<%=request.getParameter("address")%>  required/><br/>
    <input type="text" name="faculty" value=<%=request.getParameter("faculty")%>  required/><br/>
    <input type="submit" value="Update" name="submit"/><br/>
    </form>
         <%
             if(request.getParameter("submit")!=null){
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
                    String sql="update student set name=?,address=?,faculty=? where id=?";
                    PreparedStatement st=con.prepareStatement(sql);
                     st.setString(1,name);
                    st.setString(2,address);
                    st.setString(3,faculty);
                    st.setInt(4,id);
                    st.execute();
                    con.close();
                    response.sendRedirect("viewstudent.jsp");
                }
                catch(Exception e)
                {
                    out.println(e);
                }
             }
            %>
    </body>
</html>