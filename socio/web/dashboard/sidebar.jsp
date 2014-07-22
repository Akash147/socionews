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
              <li>
                  <a href="javascript:;" class="">
                      <i class="icon-refresh"></i>
                      <span>Recheck Sentiment</span>                      
                  </a>
              </li>
          </ul>
         <!-- END SIDEBAR MENU -->
      </div>
      </div>
      <!-- END SIDEBAR -->
