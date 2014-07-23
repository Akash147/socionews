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
              
              <li rel='popover' onclick="callTweet('${UserID}')">
                  <a class="sentiment">
                      <i class="icon-refresh"></i>
                      <span>Recheck Sentiment</span>  
                    </a>
              </li>
              
          </ul>
        <script type="text/javascript">
//            var name = <%=(String)session.getAttribute("screenName")%>;
            var positive_counter = 1;
            var html_tag = '\<div>Click <b>Positive</b> for positive sentiment or <b>Negative</b> for negative sentiment</div>\
                            \<div class="alert alert-info"><b>Tweet</b></br>\
                            \<div class="tweet"></div>\
                            \</div>\
                            <button type="button" class="btn btn-primary" onclick="button_hit(\'${UserID}\')">Positive</button><button type="button" class="btn btn-default" onclick="button_hit(\'${UserID}\')">Negative</button>';
            $(document).ready(function() {
                $("[rel='popover']").popover({
                    placement : 'right', // top, bottom, left or right
                    title : 'Please Check Sentiment', 
                    html: 'true', 
                    content : html_tag
                });
            });
            function button_hit(uid){
                positive_counter++;
                callTweet(uid);
            }
            function callTweet(uid) {
                var choose = "initial";
//                var count = 3;
                
                $.ajax({
                    type: "POST",
                    url: "checkSentiment",
                    data: {
                        userID : uid,
                        choice : choose,
                        tweetCount : positive_counter
                        },
                    success: function(msg){
                        $('.tweet').html(msg);
                    }
                    
                });
            }
            
        </script>
         
         
         <!-- END SIDEBAR MENU -->
      </div>
      </div>
      <!-- END SIDEBAR -->
                