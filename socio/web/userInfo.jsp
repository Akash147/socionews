<%-- 
    Document   : userInfo
    Created on : May 13, 2014, 12:28:28 AM
    Author     : Prabesh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        </br>
        <% 
            ArrayList<String> text = (ArrayList)request.getAttribute("todo");
            ArrayList<String> tags = (ArrayList)request.getAttribute("hast_tags");
            out.println(text);
            out.println(tags);;
            String accessToken = (String)request.getAttribute("accessToken");
            String accessTokenSecret = (String)request.getAttribute("accessTokenSecret");
        %>
        <p>
            Access Token is <% out.print(accessToken); %>
        </p>
        <p>
            Access TokenSecret is <% out.print(accessTokenSecret); %>
        </p>
    </body>
</html>
