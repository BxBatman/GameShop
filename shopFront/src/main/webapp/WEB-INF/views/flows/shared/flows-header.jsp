<%--
  Created by IntelliJ IDEA.
  User: Bartłomiej
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

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="pl">

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sprzedaż gier - ${title}</title>

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
    <%@include file="../shared/flows-navbar.jsp"%>
<div class="content">
