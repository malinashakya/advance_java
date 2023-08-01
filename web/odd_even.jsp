<%-- 
    Document   : session_count
    Created on : Jul 24, 2023, 11:20:05 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <form method="get" action="#">
            <input type="text" name="num1"/>
            <input type="submit" name="submit" value="submit"/>
        </form>
        <%! String num(int a)
        { if (a%2==0)
                return "even";
                else 
                    return "odd";
}
%>
        <%
            if(request.getParameter("submit")!=null)
            {
                int a=Integer.parseInt(request.getParameter("num1"));
                String c= num(a);
           
                   out.println(c);
               
            }
            %>
    </body>
</html>
