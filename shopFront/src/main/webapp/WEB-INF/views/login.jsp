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
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="${contextRoot}/home">Sklep z grami</a>
            </div>
        </div>
    </nav>

    <!-- Page Content -->
    <!--home content-->
    <div class="content">
        <div class="container">
            <c:if test="${not empty message}">
                <div class="row">
                    <div class="col-md-offset-3 col-md-6">
                        <div class="alert alert-danger">
                                ${message}
                        </div>
                    </div>
                </div>
            </c:if>


            <c:if test="${not empty logout}">
                <div class="row">
                    <div class="col-md-offset-3 col-md-6">
                        <div class="alert alert-success">
                                ${logout}
                        </div>
                    </div>
                </div>
            </c:if>



            <div class="row">
                <div class="col-md-offset-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Logowanie</h4>
                        </div>
                        <div class="panel-body">
                            <form action="${contextRoot}/login" method="POST" class="form-horizontal" id="loginForm">
                                <div class="form-group">
                                    <label for="username" class="col-md-4 control-label">E-mail:</label>
                                    <div class="col-md-8">
                                        <input type="text" name="username" id="username" class="form-control"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="password" class="col-md-4 control-label">Hasło:</label>
                                    <div class="col-md-8">
                                        <input type="password" name="password" id="password" class="form-control"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <input type="submit" value="login" class="btn btn-primary"/>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="panel-footer">
                            <div class="text-right">
                                Nowy? - <a href="${contextRoot}/register">Zarejestruj się</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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


    <!--self coded-->
    <script src="${js}/myapp.js"></script>
</div>
</body>

</html>