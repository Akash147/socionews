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
              <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#facebook">facebook</button>
              <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#facebook">twitter</button>
            </p>
          </div> 
            
<!--modal here-->

<div class="modal fade" id="facebook" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">facebook</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
            <%@include file="footer.jsp" %> 
        </div>

      </div>

    </div>
 
    </body>
    
</html>
