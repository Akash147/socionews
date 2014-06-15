<%-- 
    Document   : index
    Created on : May 9, 2014, 8:45:56 AM
    Author     : noones
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<%@include file="header.jsp" %>    
    <body>
    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">@socionews</h3>
              <ul class="nav masthead-nav">
                <li><a  href="#">About</a></li>
                <li><a href="#">Trending</a></li>
                <li><a href="#">Sign up</a></li>
                <li><a href="dashboard">Dash</a></li>
              </ul>
            </div>
          </div>

          <div class="innner cover">
            <h1 class="cover-heading">${data.title}</h1>
            <p class="lead">${data.content}</p>
            <br>
            <p>${data}</p>
            <p class="lead">
                <h2 class="cover-heading">connect with </h2>
              <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#facebook">facebook</button>
              <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#facebook">twitter</button>
            </p>
          </div> 
            
            
            <%@include file="footer.jsp" %> 
        </div>

      </div>

    </div>
 
    </body>
    
</html>
