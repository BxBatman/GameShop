<%@ page contentType="text/html;charset=ISO-8859-2" language="java" pageEncoding="ISO-8859-2" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<div class="container" style="text-align: right; width: 60%">
    <c:if test="${not empty message}">
        <div class="col-xs-8" style="text-align: center">
            <div class="alert alert-success alert-dismissable">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                    ${message}
            </div>
        </div>
    </c:if>

    <c:if test="${not empty message1}">
        <div class="col-xs-8" style="text-align: center">
            <div class="alert alert-danger alert-dismissable">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                    ${message1}
            </div>
        </div>
    </c:if>


    <div class="col-md-offset-4 col-md-12" align="center">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h4>Zarz±dzanie produktami</h4>
            </div>
            <div class="panel-body">
                <sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products"
                         method="POST" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="control-label col-md-4" for="name">Wprowad¼ nazwe produktu</label>
                        <div class="col-md-8">

                            <sf:input type="text" path="name" id="name" placeholder="Nazwa produktu"
                                      class="form-control"/>
                            <sf:errors path="name" cssClass="help-block" element="em"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-md-4" for="brand">Wprowad¼ wersje</label>
                        <div class="col-md-8">

                            <sf:input type="text" path="brand" id="brand" placeholder="Wersja" class="form-control"/>
                            <sf:errors path="brand" cssClass="help-block" element="em"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-md-4" for="description">Opis</label>
                        <div class="col-md-8">

                            <sf:textarea path="description" id="description" placeholder="Wprowadz opis"
                                         class="form-control"/>
                            <sf:errors path="description" cssClass="help-block" element="em"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-md-4" for="unitPrice">Cena</label>
                        <div class="col-md-8">

                            <sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Wprowadz cene"
                                      class="form-control"/>
                            <sf:errors path="unitPrice" cssClass="help-block" element="em"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-md-4" for="quantity">Wprowad¼ ilo¶æ</label>
                        <div class="col-md-8">

                            <sf:input type="number" path="quantity" id="quantity" class="form-control"/>
                            <sf:errors path="quantity" cssClass="help-block" element="em"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-md-4" for="file">Wybierz obraz:</label>
                        <div class="col-md-8">

                            <sf:input type="file" path="file" id="file" class="form-control"/>
                            <sf:errors path="file" cssClass="help-block" element="em"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-md-4" for="categoryId">Kategoria</label>
                        <div class="col-md-8">

                            <sf:select class="form-control" name="categoryId" path="categoryId"
                                       items="${categories}"
                                       itemLabel="name"
                                       itemValue="id"
                            />
                            </select>

                            <c:if test="${product.id == 0}">
                                <div class="text-right">
                                <br/>
                                <button type="button" data-toggle="modal" data-target="#myCategoryModal"
                                        class="btn btn-warning btn-sm">Dodaj kategorie</button>
                                </div>
                            </c:if>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-md-offset-8 col-md-8">

                            <input type="submit" name="submit" id="submit" value="Zatwierd¼" class="btn btn-primary"/>
                            <sf:hidden path="id"/>
                            <sf:hidden path="code"/>
                            <sf:hidden path="supplierId"/>
                            <sf:hidden path="active"/>
                            <sf:hidden path="purchases"/>
                            <sf:hidden path="views"/>

                        </div>
                    </div>


                </sf:form>
            </div>
        </div>
    </div>


    <div class="col-xs-12" style="text-align:center">
        <h3>Dostêpne produkty</h3>
        <hr/>
    </div>
    <div class="col-xs-12" style="text-align: left">
        <div style="overflow: auto">

            <table id="adminProductsTable" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>&#160;</th>
                    <th>Nazwa</th>
                    <th>Ilo¶æ</th>
                    <th>Cena</th>
                    <th>Aktywny</th>
                    <th>Edytuj</th>
                </tr>
                </thead>
                <tbody>
                <tr>

                    <td>8</td>
                    <td>
                        <img class="adminDataTableImg" src="${contextRoot}/resources//images/PRDF9A8C7C17E.jpg"
                             alt="Forza"/>
                    </td>
                    <td>Forza Horizon 3</td>
                    <td>2</td>
                    <td>230</td>
                    <td>
                        <label class="switch">
                            <input type="checkbox" checked="checked" value="8"/>
                            <div class="slider"/>
                        </label>
                    </td>
                    <td>
                        <a href="${contextRoot}/manage/4/product" class="btn btn-warning">
                            <span>Edit</span>
                        </a>
                    </td>
                </tr>


                <tr>

                    <td>8</td>
                    <td>
                        <img class="adminDataTableImg" src="${contextRoot}/resources//images/PRDF9A8C7C17E.jpg"
                             alt="Forza"/>
                    </td>
                    <td>Forza Horizon 3</td>
                    <td>2</td>
                    <td>230</td>
                    <td>
                        <label class="switch">
                            <input type="checkbox" value="8"/>
                            <div class="slider"/>
                        </label>
                    </td>
                    <td>
                        <a href="${contextRoot}/manage/4/product" class="btn btn-warning">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </a>
                    </td>
                </tr>


                </tbody>
                <tfoot>
                <tr>
                    <th>Id</th>
                    <th>&#160;</th>
                    <th>Nazwa</th>
                    <th>Ilo¶æ</th>
                    <th>Cena</th>
                    <th>Aktywny</th>
                    <th>Edytuj</th>
                </tr>
                </tfoot>


            </table>


        </div>
    </div>

    <div class="modal fade" id="myCategoryModal" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-body" style="text-align: center">
                    <sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" method="POST" class="form-horizontal">
                        <div class="form-group" >
                            <label for="category_name" class="control-label col-md-4">Nazwa kategorii</label>
                            <div class="col-md-12">
                                <sf:input type="text" path="name" id="category_name" class="form-control"/>
                                <sf:errors element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="category_description" class="control-label col-md-4">Opis kategorii</label>
                            <div class="col-md-12">
                                <sf:textarea cols="" rows="5" type="text" path="description" id="category_description" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-12">
                                <input type="submit" value="Dodaj" class="btn btn-primary"/>
                            </div>
                        </div>

                    </sf:form>
                </div>
            </div>
        </div>
    </div>

</div>

