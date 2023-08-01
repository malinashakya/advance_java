<%-- 
    Document   : userdata
    Created on : Jul 25, 2023, 11:17:55 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form methoid="get" action="#">
        <input type="number" name="id" placeholder="Enter id" required/><br/>
        <input type="text" name="name" placeholder="Enter name" required/><br/>
        <input type="text" name="address" placeholder="Enter address" required/><br/>
        <select name="faculty" placeholder="Choose faculty">
            <option value="BIM">
                BIM
            </option>
            <option value="BCA">
                BCA
            </option>
            <option value="CSIT">
                CSIT
            </option>
            <option value="BBA">
                BBA
            </option>
        </select>
        <input type="submit" name="submit" value="submit"/>
        </form>
        <%
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
            %>
    </body>
</html>
