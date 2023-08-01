<%-- 
    Document   : student
    Created on : Jul 31, 2023, 11:37:20 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <form method="get" action="#">
            <input type="text" name="name"/>
            <input type="text" name="faculty"/>
            <input type="number" name="age"/>
            <input type="submit" name="submit" value="submit"/>     
        </form>
        <%if (request.getParameter("submit")!=null) {%>
        <jsp:useBean id="abc" class="test.Student">
            
            <jsp:setProperty name="abc" property="name" />
            <jsp:setProperty name="abc" property="faculty" />
            <jsp:setProperty name="abc" property="age" />
            
            <p>Name: <jsp:getProperty name="abc" property="name"/></p>
            <p> Faculty: <jsp:getProperty name="abc" property="faculty"/></p>
            <p>Age: <jsp:getProperty name="abc" property="age"/></p>
            
        </jsp:useBean>
            <% } %>
    </body>
</html>
