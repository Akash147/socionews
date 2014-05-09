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
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Trending</a></li>
                <li><a href="#">Sign up</a></li>
              </ul>
            </div>
          </div>

          <div class="innner cover">
            <h1 class="cover-heading">Get Your Fresh Articles</h1>
            <p class="lead">Socionews turns any web page into a clean view for reading now or 
                later on your computer, smartphone, or tablet.</p>
            <br>
            <p class="lead">
                <h2 class="cover-heading">connect with </h2>
              <a href="#" class="btn btn-lg btn-default">facebook</a>
              <a href="#" class="btn btn-lg btn-default">twitter</a>
              <a href="#" class="btn btn-lg btn-default">linkedin</a>
            </p>
          </div>            
            <%@include file="footer.jsp" %> 
        </div>

      </div>

    </div>
 
    </body>
    
</html>
