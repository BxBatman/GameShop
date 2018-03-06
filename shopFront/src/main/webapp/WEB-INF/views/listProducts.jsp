<%@ page contentType="text/html;charset=ISO-8859-2" language="java" pageEncoding="ISO-8859-2" %>
<div class="container">
    <div class="row">
        <!-- would be to display sidebar-->
        <div class="col-md-3">

            <%@include file="./shared/sidebar.jsp" %>

        </div>


        <!-- to display actual product-->
        <div class="col-md-9">
            <!-- added breadcrumb-->

            <div class="col-lg-12">
                <c:if test="${userClickAllProducts == true}">

                    <ol class="breadcrumb">

                        <li class="breadcrumb-item"><a href="${contextRoot}/home">Strona g³ówna</a></li>
                        <li class="breadcrumb-item active">All Products</li>

                    </ol>
                </c:if>


                <c:if test="${userClickCategoryProducts == true}">

                    <ol class="breadcrumb">

                        <li class="breadcrumb-item"><a href="${contextRoot}/home">Strona g³ówna</a></li>
                        <li class="breadcrumb-item active">Kategoria</li>
                        <li class="breadcrumb-item active">${category.name}</li>

                    </ol>
                </c:if>


            </div>


        </div>
    </div>

</div>