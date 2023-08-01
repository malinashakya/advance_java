<%-- 
    Document   : num_div_5_betn
    Created on : Jul 21, 2023, 11:31:10 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Two number input divisible by 5</title>
    </head>
    <body>
        <form>
            <input type="text" name="num1" required/>
            <input type="text" name="num2" required/>
            <input type="submit" name="submit" value="submit"/>
        </form>
        <%
                
           
            if(request.getParameter("submit")!=null)
            {
                  int a=Integer.parseInt(request.getParameter("num1"));
            int b=Integer.parseInt(request.getParameter("num2"));  
             out.println("The number between"+a+"and"+b+"are:\n");
                for(int i=a;i<b;i++)
                {
                    if(i%5==0)
                    {
                        out.println(i);
                    }
                }
                    }
            %>
    </body>
</html>
