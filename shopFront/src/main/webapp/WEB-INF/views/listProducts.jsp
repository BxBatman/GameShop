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
                    <script>
                        window.categoryId = '';
                    </script>

                    <ol class="breadcrumb">

                        <li class="breadcrumb-item"><a href="${contextRoot}/home">Strona g³ówna</a></li>
                        <li class="breadcrumb-item active">All Products</li>

                    </ol>
                </c:if>


                <c:if test="${userClickCategoryProducts == true}">

                    <script>
                        window.categoryId = '${category.id}';
                    </script>

                    <ol class="breadcrumb">

                        <li class="breadcrumb-item"><a href="${contextRoot}/home">Strona g³ówna</a></li>
                        <li class="breadcrumb-item active">Kategoria</li>
                        <li class="breadcrumb-item active">${category.name}</li>

                    </ol>
                </c:if>


            </div>


            <div class="col-lg-12">
                <div class="container-fluid">
                    <div class="table-responsive">
                        <table id="productListTable" class="table table-striped table-borderd">
                            <thead>
                            <tr>
                                <th></th>
                                <th>Nazwa</th>
                                <th>Konsola</th>
                                <th>Cena</th>
                                <th>Ilo¶æ</th>
                                <th></th>
                            </tr>
                            </thead>

                            <tfoot>
                            <tr>
                                <th></th>
                                <th>Nazwa</th>
                                <th>Konsola</th>
                                <th>Cena</th>
                                <th>Ilo¶æ</th>
                                <th></th>
                            </tr>
                            </tfoot>


                        </table>
                    </div>
                </div>

            </div>


        </div>
    </div>

</div>