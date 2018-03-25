<%@ page contentType="text/html;charset=ISO-8859-2" language="java" pageEncoding="ISO-8859-2" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<div class="container" style="text-align: right; width: 60%">
    <c:if test="${not empty message}">
        <div class="col-xs-8" style="text-align: center">
            <div class="alert alert-primary alert-dismissable">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                    ${message}
            </div>
        </div>
    </c:if>
    <div class="col-md-offset-4 col-md-12" align="center">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h4>Zarz±dzanie produktami</h4>
            </div>
            <div class="panel-body">
                <sf:form class="form-horizontal"  modelAttribute="product" action="${contextRoot}/manage/products"
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

                            <sf:input type="number" path="quantity" id="quantity"  class="form-control"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-md-4" for="file">Wybierz obraz:</label>
                        <div class="col-md-8">

                            <sf:input type="file" path="file" id="file"  class="form-control"/>
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
</div>

