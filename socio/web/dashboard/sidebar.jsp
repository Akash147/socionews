<%-- 
    Document   : sidebar
    Created on : May 15, 2014, 7:25:24 PM
    Author     : noones
--%>

      <!-- BEGIN SIDEBAR -->
      <div class="sidebar-scroll">
        <div id="sidebar" class="nav-collapse collapse">

         <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
         <div class="navbar-inverse">
            <form class="navbar-search visible-phone">
               <input type="text" class="search-query" placeholder="Search" />
            </form>
         </div>
         <!-- END RESPONSIVE QUICK SEARCH FORM -->
         <!-- BEGIN SIDEBAR MENU -->
          <ul class="sidebar-menu">
              <li class="sub-menu active">
                  <a class="" href="<c:url value="/dashboard/"/>">
                      <i class="icon-dashboard"></i>
                      <span>Dashboard</span>
                  </a>
              </li>
              <li class="sub-menu">
                  <a href="javascript:;" class="">
                      <i class="icon-book"></i>
                      <span>News</span>
                      <span class="arrow"></span>
                  </a>
                  <ul class="sub">
                      <li><a class="" href="trendingnews.html">Trending</a></li>
                      <li><a class="" href="recentnews.html">Recent</a></li>
                      <li><a class="" href="hotnews.html">Hot</a></li>
                  </ul>
              </li>
              <li class="sub-menu">
                  <a href="javascript:;" class="">
                      <i class="icon-cogs"></i>
                      <span>Settings</span>
                      <span class="arrow"></span>
                  </a>
                  <ul class="sub">
                      <li><a class="" href="#">Add profile</a></li>
                      <li><a class="" href="#">Change Password</a></li>
                  </ul>
              </li>
              
              <li>
                  <a class="" href="awesomeread.jsp">
                    <i class="icon-coffee"></i>
                    <span>Awesome Read</span>
                  </a>
              </li>
              <li>
                  
              </li>
              <li data-toggle="popover" title data-content="dfa;dsfadsf" data-original-title="ajds;fa">
                  <a href="" class="sentiment">
                      <i class="icon-refresh"></i>
                      <span>Recheck Sentiment</span>  
                    </a>
              </li>
              <li>
                  <a title="" rel='popover'>Default Popover</a>
              </li>
          </ul>
         <script type="text/javascript">
$(document).ready(function() {
$("[rel='popover']").popover({
placement : 'right', // top, bottom, left or right
title : 'This is my Title', 
html: 'true', 
content : '<div style="z-index:-1;"> Argentina: all eyes on Lionel Messi as Albiceleste go for top spot in Group F - Telegraph</div>'
});
});
</script>
         
         
         <!-- END SIDEBAR MENU -->
      </div>
      </div>
      <!-- END SIDEBAR -->
                