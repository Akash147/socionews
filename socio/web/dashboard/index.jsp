<%-- 
    Document   : index
    Created on : May 9, 2014, 8:55:31 PM
    Author     : noones
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reco.DbForWeb"%>
<%@page errorPage = "error.jsp"%>

<% 
    // collect data at the start and make it valid througout the session
    String uid = request.getParameter("user");
    session.setAttribute("user", uid);
%>

<% String category = "cricket";%>
<% String miniContent = "This tutorial will help tutorial will help you to Boost your android Virtual device on Linuxytutorial will help you to Boost your android Virtual device on Linuxou to Boost your android Virtual device on Linux";%>
<% String domain = "www.techtach.com";%>
<% String link = "http://www.techtach.com";%>
<% String headLine = "Red Sox bats remain silent in loss to Tigers";%>
<% String time = "2 m";%>


<% String hotnews = "<div class=\"metro-nav-block nav-block-green long\">"
            + "<a href=\"#\" class=\"text-center\" data-original-title=\"\"><span class=\"value\">"
            + "<i class=\"icon-user\"></i>329</span><div class=\"status\">New User</div></a>"
            + "</div>";%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="header.jsp" %>

        <title>Dashboard:<c:out value="${screenName}"></c:out> </title>
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
                                <%
                                    int count = 0;
                                    int dcou = 0;
                                %>
                                <c:forEach var="eachNews" items="${recentNewsList}">
                                <%
                                    if(count%3 == 0){
                                %>
                                <div class="row-fluid thumbshow">
                                    <% dcou++; }%>
                                    
                                 <div class="span4 ${eachNews.newsId}">
                                    <div class="thumbnail">
                                        <img alt="300x200" src="${eachNews.imageThumbs}" />
                                        <div class="caption" id="${eachNews.newsId}">
                                            <h3>${eachNews.headLine}</h3>
                                            <p>${eachNews.metaDescription}</p>
                                            <span><a href="../dashboard/news?id=${eachNews.newsId}" class="btn btn-primary" role="button"><i class="icon-link"></i> Read</a> 

                                                <div class="btn-group">
                                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Action <span class="caret"></span></button>
                                                    <ul class="dropdown-menu" role="menu">
                                                        <li onclick="storeNews('${eachNews.newsId}')"><a href="#"><i class="icon-plus-sign"></i> Later</a></li>
                                                        <li onclick="del('${eachNews.newsId}')"><a href="#"><i class="icon-trash"></i> Delete</a></li>
                                                    </ul>
                                                </div>
                                            </span>
                                        </div>
                                    </div>
                                </div>  
                                
                                <%
                                    if(count%3 == 2){
                                %> 
                                </div>
                                <%
                                    }
                                    count++;
                                %>
                                </c:forEach>
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
                                <h1><i class="icon-filter"></i> Recommended News</h1>
                                <div class="desk"><div style = "height:820px;overflow:scroll; overflow-x:hidden">
                                    
                                    <c:forEach var="eachNews" items="${recentNewsList}">
                                        <div class="row-fluid experience">
                                            <a href="<c:url value="../dashboard/news?id=${eachNews.newsId}"/>"><h4>${eachNews.headLine}</h4></a>

                                            <p>${eachNews.metaDescription}</p>
                                            <a href="http://${eachNews.sourceDomain}">${eachNews.sourceDomain}</a>
                                            <div class="pull-right" style="margin-right: 20px;">
                                                <span class="small italic">Category:<a href="football.jsp">football </a></span>
                                            </div>
                                        </div>
                                    </c:forEach>

                                    <a href="#" class="pull-right">View all</a>
                                    <div class="clearfix no-top-space no-bottom-space"></div>
                                </div></div>
                            </div>
                            <!-- End of Akash here.. Remove this and make this code better -->

                        </div>
                    </div>
                </div>
            </div>
            <%@include file="footer.jsp" %>    
    </body>
    <script>
        function del(nid){
            var search_id = ".span4." + nid;
            $(search_id).remove();
        }
        function storeNews(ID){
            var search_id = ".span4." + ID;
            var search_headline = "#" + ID + " h3";
            var search_newsMeta = "#" + ID + " p";
                $.ajax({
                type: "POST",
                url: "NewsToBeRead",
                data: {
                    userID : <% out.println(session.getAttribute("UserID")); %>,
                    newsID : ID,
                    newsHead : $(search_headline).text(),
                    newsMeta : $(search_newsMeta).text()
                  },
                success: function(msg){
//                  alert(msg + "\nNews To Be read Stored successfully");
//                    $(search_id).remove();
                }
                // error: function(msg,status,error){
                //  alert(msg.responseText);
                // } 
                });
        }
    </script>
</html>
