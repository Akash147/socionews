<%-- 
    Document   : userInfo
    Created on : May 13, 2014, 12:28:28 AM
    Author     : Prabesh
--%>

<%@page import="reco.Tweets"%>
<%@page import="twitter4j.Status"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//   // New location to be redirected
//   String site = new String("dashboard/profile.jsp");
//   response.setStatus(response.SC_MOVED_TEMPORARILY);
//   response.setHeader("Location", site); 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
//            ArrayList<String> tweets = (ArrayList<String>)request.getAttribute("doto");
//            out.println(tweets);
            ArrayList<String> tweets = (ArrayList<String>)request.getAttribute("keys");
            out.println(tweets);
                        
        %>
        <%
            String image_url = (String)request.getAttribute("prof");
            out.println(image_url);
        %>
        <h1>Hello World!</h1>
        </br>
        <% 
//            ArrayList<Tweets> twet = (ArrayList<Tweets>)request.getAttribute("todo");
//            String len = (String)request.getAttribute("len");
////            ArrayList<String> tags = (ArrayList)request.getAttribute("hast_tags");
//            for(Tweets twt : twet)
//         {
//             out.println(twt.cleanTweets);
//             out.println(twt.userName);
//             out.println(twt.hashTags);
//             out.println(twt.sentiment);
//             out.println();
//         }
////            out.println(text);
////            for()
//            out.println(len);
//            String accessToken = (String)request.getAttribute("accessToken");
//            String accessTokenSecret = (String)request.getAttribute("accessTokenSecret");
        %>
        
    </body>
</html>
