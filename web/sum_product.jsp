<%-- 
    Document   : sum_product
    Created on : Jul 21, 2023, 11:47:15 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sum and product</title>
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
            int c=a+b;
            int d=a*b;
            out.println("Sum:"+c);
            out.println("Product:"+d);
            }
            
            %>
    </body>
</html>
