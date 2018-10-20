<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">

    <jsp:include page="/WEB-INF/private/head.jsp"/>  



    <body id="page-top">

        <!--====================================================
                                 HEADER
        ======================================================--> 
        <jsp:include page="/WEB-INF/private/composite/header.jsp"/>

        <!--====================================================
                            LOGIN OR REGISTER
        ======================================================-->
        <jsp:include page="/WEB-INF/private/loginorregister.jsp"/>

        <!--====================================================
                               HOME-P
        ======================================================-->



        <div id="home-p" class="home-p  text-center"> 
            <img src="${pageContext.request.contextPath}/img/news/man2.png" alt="user" style="width:7%;"> 
            <div class="container">
                <h1 class="wow fadeInUp" data-wow-delay="0.1s">Work Experience</h1>
            </div>
        </div> 


        <!--====================================================
                                FORM
        ======================================================-->
        <section class="shop-form bg-gray" id="shop-form">
            <div class="container">
                <div class="row"> 
                    <div class="col-md-10 main-login main-center">
                        <center><h4><font color="dimgray">Remove Education</font></h4></center>
                                <c:forEach items="${myeducation}" var="exp"> 
                            <form class="form-horizontal" method="post" action="">
                                <div class="form-group">
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <input type="hidden" name="do" value="delete">
                                            <input type="hidden" name="educationId"  value="${exp.educationId}">
                                            <input type="text" class="form-control" readonly="true" value="${exp.departmentId.name}"/>

                                            <span class="input-group-addon"><i class="fa fa-close fa" aria-hidden="true">
                                                    <!--     <input type="submit" value="delete">-->
                                                </i>
                                            </span><input class="btn btn-general btn-white text-center" type="submit" value="delete">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </c:forEach>
                    </div>
                </div>

                <div class="row"> 
                    <div class="col-md-10 main-login main-center">
                        <center><h4><font color="dimgray">Add Education</font></h4></center>
                        <form class="form-horizontal" method="post" action="">
                            <h6><font color="dimgray">Department Name:</font></h6>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <select class="form-control"  name="departmentId">
                                            <c:forEach items="${departments}" var="exp1">
                                                <option  value="${exp1.departmentId}">${exp1.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <h6><font color="dimgray">Degree:</font></h6>
                            <div class="form-group">
                                <div class="cols-sm-10">    
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="degree" id="degree" value="Bachelor's/Master's">
                                    </div>
                                </div>
                            </div><!--
                            <h6><font color="dimgray">Entry Year:</font></h6>
                            <div class="form-group">
                                <div class="cols-sm-10">    
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="entryyear" id="entryyear" value="yyyy">
                                    </div>  
                                </div>
                            </div>-->


                            <div class="form-group ">
                                <input type="hidden" name="do" value="add">
                                <center><input class="btn btn-general btn-white text-center" type="submit" value="Add Education"></center>
                            </div> 
                        </form>
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
