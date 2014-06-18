<%-- 
    Document   : index
    Created on : May 9, 2014, 8:55:31 PM
    Author     : noones
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% String userNames = "noones";%>
<% String fullName = "Ganesh Pandey";%>
<% /*String recentNews = ""
     + "<div class=\"row-fluid experience\">"
     + "<h4>"+headLine+"</h4><p>"+miniContent+"</p>"
     + "<a href=\""+link+"#\">"+domain+"</a>"
     + "<div class=\"pull-right\">"
     + "<span class=\"small italic\">Category:<a href=\""+category+".jsp\">"+category+" </a></span></div>"
     + "</div><div class=\"space10\"></div>"; */
%>

<% String hotnews = "<div class=\"metro-nav-block nav-block-green long\">"
            + "<a href=\"#\" class=\"text-center\" data-original-title=\"\"><span class=\"value\">"
            + "<i class=\"icon-user\"></i>329</span><div class=\"status\">New User</div></a>"
            + "</div>";%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="header.jsp" %>
        <title>Dashboard: ${user.getUserName()}</title>
    </head>
    <body class="fixed-top">
        <%@include file="navigation.jsp" %>
        <div id ="container" class="row-fluid">
            <%@include file="sidebar.jsp" %>
            <!-- BEGIN PAGE -->  
            <div id="main-content">
                <!-- BEGIN PAGE CONTAINER-->
                <div class="container-fluid">
                    <!-- BEGIN PAGE HEADER-->
                    <br/>
                    <!-- Search Begin -->
                    <!--                <div class="span7">
                                        <div class="pull-right">
                                               <form action="?q=" class="hidden-phone">
                                                   <div class="input-append search-input-area">
                                                       <input class="" id="appendedInputButton" type="text">
                                                       <button class="btn" type="button"><i class="icon-search"></i> </button>
                                                   </div>
                                               </form></div>
                                           </div>-->
                    <!-- Search End--><hr>
                    <div class="row-fluid">
                        <div class="span8">

                            <div class="row-fluid">
                            </div>
                            <div class="row-fluid">
                            </div>
                            <div class="row-fluid">      
                            </div>

                            <div class="space10"></div>
                        </div>

                        <div class="span4">
                            <!-- Akash Here -->
                            <div class="profile-side-box green">
                                <div class="desk">
                                    <h1><i class="icon-filter"></i> Recommended News</h1>
                                    <c:forEach var="eachNews" items="${recentNewsList}">
                                        <div class="row-fluid experience">
                                            <h4>${eachNews.headLine}</h4>
                                            <p>Description of news</p>
                                            <a href="http://www.techtach.com#">${eachNews.sourceLink}</a>
                                            <div class="pull-right">
                                                <span class="small italic">Category:<a href="cricket.jsp">cricket </a></span>
                                            </div>
                                        </div>
                                    </c:forEach>

                                    <a href="#" class="pull-right">View all</a>
                                    <div class="clearfix no-top-space no-bottom-space"></div>
                                </div>
                            </div>
                            <!-- End of Akash here.. Remove this and make this code better -->

                        </div>
                    </div>
                </div>
            </div>
            <%@include file="footer.jsp" %>    
    </body>
</html>
