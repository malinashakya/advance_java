<%-- 
    Document   : read_word_reverse
    Created on : Jul 21, 2023, 11:39:54 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read word and reverse the word</title>
    </head>
    <body>
        <form>
            <input type="text" name="word" required/>
            <input type="submit" name="submit" value="submit"/>
        </form>
        <%
            if(request.getParameter("submit")!=null)
            {
            String words=request.getParameter("word");
            out.println("the reverse word is :");
            int len=words.length();
            out.println("Length:"+len);
            for(int i=len-1;i>=0;i--)
            {
                out.println(words.charAt(i));
            }
            }
            %>
    </body>
</html>
