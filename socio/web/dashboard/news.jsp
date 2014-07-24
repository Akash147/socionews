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
        <link href='http://fonts.googleapis.com/css?family=Libre+Baskerville:400,700' rel='stylesheet' type='text/css'>
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

                            <div class="row-fluid">
                                <div class="span12">
                                    <div class="news-head">
                                        <h1>${nowShowingNews.headLine}</h1>
                                        <div style="margin-bottom:0px; padding-bottom:1px;">
                                            <p style="text-align:left; margin-bottom:0px; padding-bottom:1px;">
                                                <button type="button" class="btn btn-large btn-default"style="height:60px; width:74px"><i class="icon-2x icon-share"></i></button>
                                                <button type="button" class="btn btn-large btn-primary"style="height:60px; width:74px"><i class="icon-2x icon-facebook"></i></button>
                                                <button type="button" class="btn btn-large btn-success"style="height:60px; width:74px"><i class="icon-2x icon-twitter"></i></button>
                                                <button type="button" class="btn btn-large btn-danger"style="height:60px; width:74px"><i class="icon-2x icon-google-plus"></i></button>
                                            </p>
                                            <p style="float: right">By: <a href="http://${nowShowingNews.sourceDomain}">${nowShowingNews.sourceDomain}</a>
                                                <span>Jun 19, 2014</span></p>
                                        </div>
<!--                                        <div class="alert alert-success fade in" style="position: fixed;bottom: 0;right: 0; z-index: 1000; text-align:center";>
                                            <h4>Feedback!</h4>
                                            <p>Helps us to improve your news dashboard.</p>
                                            <form>
                                            <div class="control-group" style="text-align:center; margin: auto">
                                                <label class="control-label">Do you like this news?</label>
                                               <label class="radio-inline">
                                                <input type="radio" id="inlineCheckbox1" name="feed1" value="1"> yes
                                              </label>
                                              <label class="radio-inline">
                                                <input type="radio" id="inlineCheckbox2" name="feed1" value="0"> No
                                              </label>
                                            </div>
                                        </form>
                                            <button type="button" data-dismiss="alert" class="btn btn-medium btn-danger">feedback</button>
                                        </div>-->
                                        
                                        <hr>

                                    </div>
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
                                <h1><i class="icon-filter"></i> Recommended News</h1>
                                <div class="desk"><div style = "height:820px;overflow:scroll; overflow-x:hidden">
                                    
                                    <c:forEach var="eachNews" items="${recentNewsList}">
                                        <div class="row-fluid experience">
                                            <a href="<c:url value="../dashboard/news?id=${eachNews.newsId}"/>"><h4>${eachNews.headLine}</h4></a>
                                            <p>${eachNews.metaDescription}</p>
                                            <a href="http://${eachNews.sourceDomain}">${eachNews.sourceDomain}</a>
                                            <div class="pull-right" style="margin-right: 20px;">
                                                <span class="small italic">Category:<a href="cricket.jsp">cricket </a></span>
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
</html>
