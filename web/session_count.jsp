<%-- 
    Document   : session_count
    Created on : Jul 24, 2023, 11:20:05 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="get" action="#">
            <input type="text" name="num1"/>
            <input type="text" name="num2"/>
            <input type="submit" name="submit" value="submit"/>
        </form>
        <%! int add(int a, int b)
        {return a+b;
}
%>
        <%
            if(request.getParameter("submit")!=null)
            {
                int a=Integer.parseInt(request.getParameter("num1"));
                int b=Integer.parseInt(request.getParameter("num2"));
                int c= add(a,b);
                out.println("sum: "+c);
            }
            %>
    </body>
</html>
