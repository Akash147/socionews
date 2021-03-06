
<%@page import="reco.NewsToBe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="reco.DbForWeb"%>
<%-- 
    Document   : profile
    Created on : May 20, 2014, 12:47:32 PM
    Author     : noones
--%>
<% String category="cricket" ;%>
<% String miniContent1="Alejandro Sabella has denied Argentina are over-dependent on captain Lionel Messi -- but stressed that his ";%>
<% String miniContent2="Angel di Maria felt Argentina did not ‘get desperate’ during the last-gasp victory over Switzerland ...";%>
<% String domain="www.techtach.com";%>
<% String link="http://www.techtach.com";%>
<% String headLine1="Lionel Messi not over-relied on - Argentina coach Alejandro Sabella - ESPN FC" ;%>
<% String headLine2="World Cup: Angel di Maria and Javier Mascherano praise Argentina's win over Switzerland | News" ;%>
<% String time = "2 m" ;%>
<% String userNames = "noones" ;%>
<% String fullName = "Ganesh Pandey" ;%>
<% String recentNews1 = ""
        + "<div class=\"row-fluid experience\">"
        + "<h4>"+headLine1+"</h4><p>"+miniContent1+"</p>"
        + "<a href=\""+link+"#\">"+domain+"</a>"
        + "<div class=\"pull-right\">"
        + "<span class=\"small italic\">Category:<a href=\""+category+".jsp\">"+category+" </a></span></div>"
        + "</div><div class=\"space10\"></div>"; 
%>
<% String recentNews2 = ""
        + "<div class=\"row-fluid experience\">"
        + "<h4>"+headLine2+"</h4><p>"+miniContent2+"</p>"
        + "<a href=\""+link+"#\">"+domain+"</a>"
        + "<div class=\"pull-right\">"
        + "<span class=\"small italic\">Category:<a href=\""+category+".jsp\">"+category+" </a></span></div>"
        + "</div><div class=\"space10\"></div>"; 
%>

<%
    DbForWeb dfw = new DbForWeb();
    ArrayList<NewsToBe> newsT = new ArrayList<NewsToBe>();
    newsT = dfw.getNewsToBeRead(Long.parseLong(session.getAttribute("UserID").toString()));
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="header.jsp" %>
        <title><%=session.getAttribute("screenName") %>  ::Profile</title>
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
            <div class="row-fluid">
               <div class="span12">
                  
                  <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                   <h3 class="page-title">
                     Profile
                   </h3>
                   
               </div>
            </div>
            <!-- END PAGE HEADER-->
            <!-- BEGIN PAGE CONTENT-->
             <div class="row-fluid">
                 <!-- BEGIN PROFILE PORTLET-->
                 <div class=" profile span12">
                     <div class="span2">
                         <div class="profile-photo">
                             <img src="<%=session.getAttribute("profileImage") %>" alt="">
                             Connected:<span class="pull-right">
                                 
                                     <a href="#">
                                         <i class="icon-facebook large"></i>
                                     </a>
                                     <a href="#">
                                         <i class="icon-twitter large"></i>
                                     </a>
                                     <a href="#">
                                         <i class="icon-linkedin large"></i>
                                     </a>
                                 </span>
                             <br/><br/><b>Tasks remaining</b>
                             
                             <ul class="unstyled">
                                     <li>
                                         <i class="icon-facebook large"></i> facebook:<strong class="label label-success"> 80%</strong>
                                         <div class="space10"></div>
                                         <div class="progress progress-success">
                                             <div class="bar" style="width: 80%;"></div>
                                         </div>
                                     </li>
                                     
                                     <li>
                                         <i class="icon-twitter large"></i> twitter:<strong class="label label-success"> 80%</strong>
                                         <div class="space10"></div>
                                         <div class="progress progress-success">
                                             <div class="bar" style="width: 80%;"></div>
                                         </div>
                                     </li>
                                     
                                     <li>
                                         <i class="icon-linkedin large"></i> linkedin:<strong class="label label-warning"> 0%</strong>
                                         <div class="space10"></div> 
                                         <div class="progress progress-danger">
                                             <div class="bar" style="width: 0%;"></div>
                                         </div>
                                     </li>

                                 </ul>

                            </div>
                     </div>
                     <div class="span10">
                         <div class="profile-head">
                             <div class="span4">
                                 <h3><b><%=session.getAttribute("fullName") %></b></h3>
                                 <p>Joined Since : <b><%=session.getAttribute("createdDate") %></b></p>
                             </div>
                             <div class="span4">
                             </div>
                             <div class="span4">
                                 <a href="#" class="btn btn-edit btn-large pull-right mtop20"> Edit </a>
                             </div>
                         </div>
                                 
                         <div class="space1"></div><hr>
                         <div class="row-fluid">
                             <div class="span4 bio">
                                 <div class="space15"></div>
                                 <h3>Bio Graph</h3>
                                 <p><label>Location </label>: <%=session.getAttribute("location") %></p>
                                 <p><label>User Description </label>: <%=session.getAttribute("userDescription") %></p>
                                 <p><label>Following  </label>: <%=session.getAttribute("following") %></p>
                                 
                                 
                                 <p><label><i class="icon-twitter large"></i> Twitter </label>: <a href="https://twitter.com/<%=session.getAttribute("screenName") %>" target="_BLANK">@<%=session.getAttribute("screenName") %></a></p>
                                 
                                 <div class="space15"></div>
                                 <hr>
                                 <div class="space15"></div>

                                 <h2>Project Progress</h2>
                                 
                                 <div class="text-center">
                                     <button class="btn btn-primary ">All Projects</button>
                                 </div>
                                 <div class="space20"></div>
                             </div>
                             
                             <div class="span4">
                        
                          <div class="profile-side-box green">
                              <div class="desk">
                                     <h1>To be read </h1>
                                        <%
                                            for(NewsToBe ntb : newsT){
                                                %>
                                                <div class="row-fluid experience">
                                                    <h4>
                                                        <a href="../dashboard/news?id=<% out.println(ntb.newsID); %>">
                                                        <%
                                                            out.println(ntb.newsHead);
                                                        %>
                                                        </a>
                                                    </h4>
                                                    <p>
                                                        <%
                                                            out.println(ntb.newsShort);
                                                        %>
                                                    </p>
                                                </div>
                                                <%
                                            }
                                        %>
                                        
                             <a href="#" class="pull-right">View all</a>
                             <div class="clearfix no-top-space no-bottom-space"></div>
                              </div></div>
                             </div>
                             
                             <div class="span4">
                                 <div class="profile-side-box red">
                                     <h1>You may also like</h1>
                                     
                                     </div>
                                 </div>
                                 
                             </div>
                         </div>
                     </div>
                 </div>
                 <!-- END PROFILE -->
             </div>
            <!-- END PAGE CONTENT-->
            </div>
       </div>
        <%@include file="footer.jsp" %>    
    </body>
    
    
</html>
