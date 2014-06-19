<%-- 
    Document   : index
    Created on : May 9, 2014, 8:55:31 PM
    Author     : noones
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String category = "cricket";%>
<% String miniContent = "This tutorial will help tutorial will help you to Boost your android Virtual device on Linuxytutorial will help you to Boost your android Virtual device on Linuxou to Boost your android Virtual device on Linux";%>
<% String domain = "www.techtach.com";%>
<% String link = "http://www.techtach.com";%>
<% String headLine = "Red Sox bats remain silent in loss to Tigers";%>
<% String time = "2 m";%>
<% String userNames = "noones";%>
<% String fullName = "Ganesh Pandey";%>

<% String hotnews = "<div class=\"metro-nav-block nav-block-green long\">"
            + "<a href=\"#\" class=\"text-center\" data-original-title=\"\"><span class=\"value\">"
            + "<i class=\"icon-user\"></i>329</span><div class=\"status\">New User</div></a>"
            + "</div>";%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="header.jsp" %>

        <title>${nowShowingNews.headLine}</title>
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
                            <div class="alert alert-success">you have <b>21</b> news recommendation <b>12</b> on <i>football</i> and <b>9</b> on <i>Cricket</i>
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                <div class="progress">
                                    <div class="bar bar-success" style="width: 65%;"></div>
                                    <div class="bar bar-warning" style="width: 35%;"></div>
                                </div>
                            </div>
                            <div class="row-fluid">
                                <div class="span12">
                                    <h4>${nowShowingNews.headLine}</h4>
                                    ${nowShowingNews.newsContent}
                                </div>

                            </div>


                            <div class="space10"></div>
                            <!--END METRO STATES-->

                            <!-- Recent News  begin --> 
                            <!--                    <div class="profile-side-box">
                                                          <div class="desk">
                                                                 <h1><i class="icon-time"></i> Latest News</h1>
                            <%for (int f = 1; f <= 10; f++) { %>
                                               { recentNews }
                            <%}%>
                    <a href="#" class="pull-right">View all</a>
                    <div class="clearfix no-top-space no-bottom-space"></div>
                     </div></div>-->
                            <!-- Recent News End--> 
                        </div>

                    <!-- Recommended News SideBar -->
                        <div class="span4">
                            <!-- Akash Here -->
                            <div class="profile-side-box green">
                                <div class="desk">
                                    <h1><i class="icon-filter"></i> Recommended News</h1>
                                    <c:forEach var="eachNews" items="${recentNewsList}">
                                        <div class="row-fluid experience">
                                            <a href="<c:url value="/news/?id=${eachNews.newsId}"/>"><h4>${eachNews.headLine}</h4></a>
                                            <p>${eachNews.metaDescription}</p>
                                            <a href="http://${eachNews.sourceDomain}">${eachNews.sourceDomain}</a>
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
