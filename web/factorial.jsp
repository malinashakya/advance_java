
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorial</title>
    </head>
    <body>
        <form>
            <input type="text" name="Num1" required/>
            <input type="submit" name="submit" value="submit"/>
        </form>
        <%
            if(request.getParameter("submit")!=null)
            {
                int a=Integer.parseInt(request.getParameter("Num1"));
                int fact=1;
                while(a>0)
                {
                    fact=fact*a;
                    a--;
                }
                out.println("Factorial="+ fact);
            }
            %>
    </body>
</html>
