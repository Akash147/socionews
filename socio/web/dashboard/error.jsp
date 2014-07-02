<%-- 
    Document   : error
    Created on : Jul 2, 2014, 12:13:07 PM
    Author     : Prabesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            response.sendRedirect(request.getContextPath());
        %>
    </body>
</html>
