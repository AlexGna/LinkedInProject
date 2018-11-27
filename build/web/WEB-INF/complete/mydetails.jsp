<%-- 
    Document   : userdetails
    Created on : Sep 5, 2018, 5:57:52 AM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>

 <jsp:include page="/WEB-INF/private/head.jsp"/>       

  <body id="page-top">

<!--====================================================
                         HEADER
======================================================--> 
 
    <header>
        
        <jsp:include page="/WEB-INF/private/topmenubar.jsp"/>


      <!-- Navbar -->
      
      <jsp:include page="/WEB-INF/private/navbar.jsp"/>

    </header> 
      
        <!--====================================================
                               HOME-P
        ======================================================-->

       <div id="home-p" class="home-p  text-center"> 
        <img src="${pageContext.request.contextPath}/img/news/man2.png" alt="user" style="width:7%;"> 
            <div class="container">
                <h4 class="wow fadeInUp" data-wow-delay="0.1s">${me.firstname} ${me.surname}</h4>
            </div>
        </div> 
      
      

<!--====================================================
                      NEWS DETAILS
======================================================--> 
    <section id="single-news-p1" class="single-news-p1">
      <div class="container" style="width:35%"> 

            <div class="single-news-p1-cont">
                <hr>                
                <div class="bg-light-gray">  
                    <center><h5>Education</h5></center>
                    <p class="mb-0">&nbsp;</p>                                                     
                </div> 
                
                <hr>
                <div class="bg-light-gray">  
                    <center><h5>Skills</h5></center>
                    <p class="mb-0">&nbsp;</p>                                   
                </div> 
                
                <hr>
                <div class="bg-light-gray"> 
                    <center><h5>Experience</h5></center>
                    <p class="mb-0">&nbsp;</p>                                  
                </div>                  
                
                <hr> 
                
                <div class="comment-box-sn">
                    <a href="${pageContext.request.contextPath}/networklist"> 
                        <button class="btn btn-general btn-green" style="width: 100%;" role="button">Start Conversation</button></a>
                </div>
                
                <hr>                
              </div>
            </div> 
     </div>
    </section>
 

<!--====================================================
                      FOOTER
======================================================--> 
         <jsp:include page="/WEB-INF/private/footer.jsp"/>

        <!--Global JavaScript -->
        <jsp:include page="/WEB-INF/private/code/js.jsp"/>
  </body>
  
</html>
