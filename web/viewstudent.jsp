<%-- 
    Document   : viewstudent
    Created on : Jul 25, 2023, 11:14:31 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" width="600" align="center">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Address</th>
                <th>Faculty</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <%
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
            %>
            <tr><td><% out.println(rs.getString("id")); %></td><td><% out.println(rs.getString("name")); %></td>
                <td><% out.println(rs.getString("address")); %></td><td><% out.println(rs.getString("faculty"));%></td>   
                <td><a href='update.jsp?id=<%=rs.getString("id")%>&name=<%=rs.getString("name")%>
                       &address=<%=rs.getString("address")%>&faculty=<%=rs.getString("faculty")%>'>Update</a></td>
                <td><a href='delete.jsp?id=<%=rs.getString("id")%>' onclick="return confirm('Are you sure?')" >Delete</a></td>
            </tr>
            <%
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

            %>
        </table>
    <center>
        <%
            for(int i=0;i<total/recordcount;i++)
            {%>
            <a href="viewstudent.jsp?pgno=<%=i%>">Page<%=i+1%></a>
            <%}
        %>
    </center>
    </body>
</html>
