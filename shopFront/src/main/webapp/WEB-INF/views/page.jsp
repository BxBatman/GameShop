<%--
  Created by IntelliJ IDEA.
  User: Bart�omiej
  Date: 2018-02-28
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-2" language="java" pageEncoding="ISO-8859-2"


%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>
<spring:url var="ads" value="/resources/ads"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="pl">

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="_csrf" content="${_csrf.token}">
    <meta name="_csrf_header" content="${_csrf.headerName}">

    <title>Sprzeda� gier - ${title}</title>

    <script>
        window.menu = '${title}';

        window.contextRoot = '${contextRoot}'
    </script>


    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">


    <!--custom bootstrap css-->
    <link href="${css}/bootstrap-slate-theme.css" rel="stylesheet">

    <!--botstrap table css-->
    <link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">


</head>

<body>
<div class="wrapper">
    <!-- Navigation -->
    <%@include file="./shared/navbar.jsp" %>

    <!-- Page Content -->
    <!--home content-->
    <div class="content">
        <c:if test="${userClickHome == true}">
            <%@include file="./home.jsp" %>
        </c:if>


        <!--about-->
        <c:if test="${userClickAbout == true}">
            <%@include file="./about.jsp" %>
        </c:if>


        <!--contact-->
        <c:if test="${userClickContact == true}">
            <%@include file="./contact.jsp" %>
        </c:if>


        <!--products-->
        <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
            <%@include file="./listProducts.jsp" %>
        </c:if>
        <c:if test="${userClickShowProduct == true}">
            <%@include file="./singleProduct.jsp" %>
        </c:if>
        <c:if test="${userClickManageProducts == true}">
            <%@include file="./manageProducts.jsp" %>
        </c:if>
        <c:if test="${userClickShowCart == true}">
            <%@include file="./cart.jsp" %>
        </c:if>

        <c:if test="${userClickShowPayment == true}">
            <%@include file="./payment.jsp"%>
        </c:if>


    </div>


    <!-- /.container -->

    <!-- Footer -->
    <%@include file="./shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/jquery.validate.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>

    <!--datatables jquery-->
    <script src="${js}/jquery.dataTables.js"></script>

    <!--datatable bootstrap-->
    <script src="${js}/dataTables.bootstrap4.js"></script>
    <!-- Bootbox-->
    <script src="${js}/bootbox.min.js"></script>
    <!--self coded-->
    <script src="${js}/myapp.js"></script>
</div>
</body>

</html>

