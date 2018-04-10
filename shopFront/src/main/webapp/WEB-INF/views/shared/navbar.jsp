<%@ page contentType="text/html;charset=ISO-8859-2" language="java" pageEncoding="ISO-8859-2" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home">Sprzeda¿ gier PS4/PS3/XBOX/PC</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li id="about" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/about">O nas</a>
                </li>
                <li id="listProducts" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/show/all/products">Lista produktów</a>
                </li>
                <li id="contact" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/contact">Kontakt</a>
                </li>
                <security:authorize access="hasAnyAuthority('ADMIN')">
                <li id="manageProducts" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/manage/products">Zarz±dzaj produktami</a>
                </li>
                </security:authorize>
                <security:authorize access="isAnonymous()">
                    <li id="register" class="nav-item">
                        <a class="nav-link" href="${contextRoot}/register">Zarejestruj siê</a>
                    </li>
                    <li id="login" class="nav-item">
                        <a class="nav-link" href="${contextRoot}/login">Zaloguj siê</a>
                    </li>
                </security:authorize>


                <security:authorize access="isAuthenticated()">
                    <li class="dropdown" id="userCart">

                        <a href="javascript:void(0)" class="btn btn-default dropdown-toggle" id="dropdownMenu1"
                           data-toggle="dropdown">
                                ${userModel.fullName}
                            <span class="caret"></span>
                        </a>

                        <ul class="dropdown-menu">

                            <security:authorize access="hasAnyAuthority('USER')">
                                <li><a class="nav-link" href="${contextRoot}/cart/show">
                                    <span class="badge">${userModel.cart.cartLines}</span>
                                        ${userModel.cart.grandTotal} z³
                                </a></li>
                                <li class="divider" role="separator"/>
                            </security:authorize>
                            <li>
                                <a class="nav-link" href="${contextRoot}/perform-logout">Wyloguj siê</a>
                            </li>
                        </ul>
                    </li>
                </security:authorize>

            </ul>


        </div>
    </div>
</nav>

<script>
    window.userRole = '${userModel.role}';
</script>

