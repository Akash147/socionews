<%-- 
    Document   : index
    Created on : May 9, 2014, 8:55:31 PM
    Author     : noones
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String category="cricket" ;%>
<% String miniContent="This tutorial will help tutorial will help you to Boost your android Virtual device on Linuxytutorial will help you to Boost your android Virtual device on Linuxou to Boost your android Virtual device on Linux";%>
<% String domain="www.techtach.com";%>
<% String link="http://www.techtach.com";%>
<% String headLine="Red Sox bats remain silent in loss to Tigers" ;%>
<% String time = "2 m" ;%>
<% String userNames = "noones" ;%>
<% String fullName = "Ganesh Pandey" ;%>
<% /*String recentNews = ""
        + "<div class=\"row-fluid experience\">"
        + "<h4>"+headLine+"</h4><p>"+miniContent+"</p>"
        + "<a href=\""+link+"#\">"+domain+"</a>"
        + "<div class=\"pull-right\">"
        + "<span class=\"small italic\">Category:<a href=\""+category+".jsp\">"+category+" </a></span></div>"
        + "</div><div class=\"space10\"></div>"; */
%>

<% String hotnews="<div class=\"metro-nav-block nav-block-green long\">"
        + "<a href=\"#\" class=\"text-center\" data-original-title=\"\"><span class=\"value\">"
        + "<i class=\"icon-user\"></i>329</span><div class=\"status\">New User</div></a>"
        + "</div>" ;%>

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
<div class="alert alert-success">you have <b>21</b> news recommendation <b>12</b> on <i>football</i> and <b>9</b> on <i>Cricket</i>
<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
  <div class="progress">
                                <div class="bar bar-success" style="width: 65%;"></div>
                                <div class="bar bar-warning" style="width: 35%;"></div>
                            </div>
</div>
        <div class="row-fluid">
            <div class="span4">
                <div class="thumbnail">
          <img data-src="holder.js/300x200" alt="300x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzMDAiIGhlaWdodD0iMjAwIj48cmVjdCB3aWR0aD0iMzAwIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI2VlZSI+PC9yZWN0Pjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjE1MCIgeT0iMTAwIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjE5cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MzAweDIwMDwvdGV4dD48L3N2Zz4=">
          <div class="caption">
            <h3>Thumbnail label</h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            <span><a href="#" class="btn btn-primary" role="button"><i class="icon-link"></i> Read</a> 
             
                    <div class="btn-group">
                         <button data-toggle="dropdown" class="btn dropdown-toggle">Action <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                         <li><a href="#"><i class="icon-plus-sign"></i> Later</a></li>
                         <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                     </div></span>
          </div>
        </div>
            </div>
            
            <div class="span4">
                <div class="thumbnail">
          <img data-src="holder.js/300x200" alt="300x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzMDAiIGhlaWdodD0iMjAwIj48cmVjdCB3aWR0aD0iMzAwIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI2VlZSI+PC9yZWN0Pjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjE1MCIgeT0iMTAwIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjE5cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MzAweDIwMDwvdGV4dD48L3N2Zz4=">
          <div class="caption">
            <h3>Thumbnail label</h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
          <span><a href="#" class="btn btn-primary" role="button"><i class="icon-link"></i> Read</a> 
             
                    <div class="btn-group">
                         <button data-toggle="dropdown" class="btn dropdown-toggle">Action <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                         <li><a href="#"><i class="icon-plus-sign"></i> Later</a></li>
                         <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                     </div></span>  
          </div>
        </div>
            </div>
            
            <div class="span4">
                <div class="thumbnail">
          <img data-src="holder.js/300x200" alt="300x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzMDAiIGhlaWdodD0iMjAwIj48cmVjdCB3aWR0aD0iMzAwIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI2VlZSI+PC9yZWN0Pjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjE1MCIgeT0iMTAwIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjE5cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MzAweDIwMDwvdGV4dD48L3N2Zz4=">
          <div class="caption">
            <h3>Thumbnail label</h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
          <span><a href="#" class="btn btn-primary" role="button"><i class="icon-link"></i> Read</a> 
             
                    <div class="btn-group">
                         <button data-toggle="dropdown" class="btn dropdown-toggle">Action <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                         <li><a href="#"><i class="icon-plus-sign"></i> Later</a></li>
                         <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                     </div></span>  
          </div>
        </div>
            </div>
            
        </div>
      
      
      
              <div class="row-fluid">
            <div class="span4">
                <div class="thumbnail">
          <img data-src="holder.js/300x200" alt="300x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzMDAiIGhlaWdodD0iMjAwIj48cmVjdCB3aWR0aD0iMzAwIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI2VlZSI+PC9yZWN0Pjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjE1MCIgeT0iMTAwIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjE5cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MzAweDIwMDwvdGV4dD48L3N2Zz4=">
          <div class="caption">
            <h3>Thumbnail label</h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            <span><a href="#" class="btn btn-primary" role="button"><i class="icon-link"></i> Read</a> 
             
                    <div class="btn-group">
                         <button data-toggle="dropdown" class="btn dropdown-toggle">Action <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                         <li><a href="#"><i class="icon-plus-sign"></i> Later</a></li>
                         <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                     </div></span>
          </div>
        </div>
            </div>
            
            <div class="span4">
                <div class="thumbnail">
          <img data-src="holder.js/300x200" alt="300x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzMDAiIGhlaWdodD0iMjAwIj48cmVjdCB3aWR0aD0iMzAwIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI2VlZSI+PC9yZWN0Pjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjE1MCIgeT0iMTAwIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjE5cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MzAweDIwMDwvdGV4dD48L3N2Zz4=">
          <div class="caption">
            <h3>Thumbnail label</h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
          <span><a href="#" class="btn btn-primary" role="button"><i class="icon-link"></i> Read</a> 
             
                    <div class="btn-group">
                         <button data-toggle="dropdown" class="btn dropdown-toggle">Action <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                         <li><a href="#"><i class="icon-plus-sign"></i> Later</a></li>
                         <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                     </div></span>  
          </div>
        </div>
            </div>
            
            <div class="span4">
                <div class="thumbnail">
          <img data-src="holder.js/300x200" alt="300x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzMDAiIGhlaWdodD0iMjAwIj48cmVjdCB3aWR0aD0iMzAwIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI2VlZSI+PC9yZWN0Pjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjE1MCIgeT0iMTAwIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjE5cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MzAweDIwMDwvdGV4dD48L3N2Zz4=">
          <div class="caption">
            <h3>Thumbnail label</h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
          <span><a href="#" class="btn btn-primary" role="button"><i class="icon-link"></i> Read</a> 
             
                    <div class="btn-group">
                         <button data-toggle="dropdown" class="btn dropdown-toggle">Action <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                         <li><a href="#"><i class="icon-plus-sign"></i> Later</a></li>
                         <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                     </div></span>  
          </div>
        </div>
            </div>
            
        </div>
      
      
              <div class="row-fluid">
            <div class="span4">
                <div class="thumbnail">
          <img data-src="holder.js/300x200" alt="300x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzMDAiIGhlaWdodD0iMjAwIj48cmVjdCB3aWR0aD0iMzAwIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI2VlZSI+PC9yZWN0Pjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjE1MCIgeT0iMTAwIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjE5cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MzAweDIwMDwvdGV4dD48L3N2Zz4=">
          <div class="caption">
            <h3>Thumbnail label</h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            <span><a href="#" class="btn btn-primary" role="button"><i class="icon-link"></i> Read</a> 
             
                    <div class="btn-group">
                         <button data-toggle="dropdown" class="btn dropdown-toggle">Action <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                         <li><a href="#"><i class="icon-plus-sign"></i> Later</a></li>
                         <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                     </div></span>
          </div>
        </div>
            </div>
            
            <div class="span4">
                <div class="thumbnail">
          <img data-src="holder.js/300x200" alt="300x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzMDAiIGhlaWdodD0iMjAwIj48cmVjdCB3aWR0aD0iMzAwIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI2VlZSI+PC9yZWN0Pjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjE1MCIgeT0iMTAwIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjE5cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MzAweDIwMDwvdGV4dD48L3N2Zz4=">
          <div class="caption">
            <h3>Thumbnail label</h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
          <span><a href="#" class="btn btn-primary" role="button"><i class="icon-link"></i> Read</a> 
             
                    <div class="btn-group">
                         <button data-toggle="dropdown" class="btn dropdown-toggle">Action <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                         <li><a href="#"><i class="icon-plus-sign"></i> Later</a></li>
                         <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                     </div></span>  
          </div>
        </div>
            </div>
            
            <div class="span4">
                <div class="thumbnail">
          <img data-src="holder.js/300x200" alt="300x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzMDAiIGhlaWdodD0iMjAwIj48cmVjdCB3aWR0aD0iMzAwIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI2VlZSI+PC9yZWN0Pjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjE1MCIgeT0iMTAwIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjE5cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MzAweDIwMDwvdGV4dD48L3N2Zz4=">
          <div class="caption">
            <h3>Thumbnail label</h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
          <span><a href="#" class="btn btn-primary" role="button"><i class="icon-link"></i> Read</a> 
             
                    <div class="btn-group">
                         <button data-toggle="dropdown" class="btn dropdown-toggle">Action <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                         <li><a href="#"><i class="icon-plus-sign"></i> Later</a></li>
                         <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                     </div></span>  
          </div>
        </div>
            </div>
            
        </div>

                <div class="space10"></div>
                <!--END METRO STATES-->

            <!-- Recent News  begin --> 
<!--                    <div class="profile-side-box">
                              <div class="desk">
                                     <h1><i class="icon-time"></i> Latest News</h1>
                         <%for ( int f = 1; f <= 10; f++){ %>
                                            { recentNews }
                                     <%}%>
                             <a href="#" class="pull-right">View all</a>
                             <div class="clearfix no-top-space no-bottom-space"></div>
                              </div></div>-->
            <!-- Recent News End--> 
                   </div>
                             
                <div class="span4">
                    <!-- News recommendation begin --> 
                   <div class="profile-side-box green">
                              <div class="desk">
                                     <h1><i class="icon-filter"></i> Recommended News</h1>
                         <%for ( int f = 1; f <= 10; f++){ %>
                                            ${recentNews}
                                     <%}%>
                             <a href="#" class="pull-right">View all</a>
                             <div class="clearfix no-top-space no-bottom-space"></div>
                              </div></div>
            <!-- News recommendation End--> 
            </div>
            </div>
            </div>
       </div>
        <%@include file="footer.jsp" %>    
    </body>
</html>
