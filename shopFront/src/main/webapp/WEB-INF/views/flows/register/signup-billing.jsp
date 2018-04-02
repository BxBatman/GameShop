<%@ page contentType="text/html;charset=ISO-8859-2" language="java" pageEncoding="ISO-8859-2" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp" %>
<div class="container" style="width: 60%;" align="center">

        <div class="col-md-12 col-md-offset-3" align="center">
            <div class="panel panel-primary">
                <div class="panel panel-heading">
                    <h4>Zarejestruj siê - Adres</h4>
                </div>
                <div class="panel-body">
                    <sf:form method="POST" class="form-horizontal" id="billingForm" modelAttribute="billing">
                        <div class="form-group">
                            <label class="control-label col-md-4" for="addressLineOne">Adres</label>

                            <div class="col-md-8">
                                <sf:input type="text" path="addressLineOne" class="form-control" placeholder="Adres"/>
                                <sf:errors path="addressLineOne" cssClass="help-block" element="em"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="control-label col-md-4" for="addressLineTwo">Dodatkowe wskazówki(niewymaganae)</label>

                            <div class="col-md-8">
                                <sf:input type="text" path="addressLineTwo" class="form-control" placeholder="np.Obok sklepu "/>

                            </div>
                        </div>



                        <div class="form-group">
                            <label class="control-label col-md-4" for="city">Miasto</label>

                            <div class="col-md-8">
                                <sf:input type="text" path="city" class="form-control" placeholder="Miasto"/>
                                <sf:errors path="city" cssClass="help-block" element="em"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="control-label col-md-4" for="postalCode">Kod pocztowy</label>

                            <div class="col-md-8">
                                <sf:input type="text" path="postalCode" class="form-control" placeholder="xxxxx"/>
                                <sf:errors path="postalCode" cssClass="help-block" element="em"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="control-label col-md-4" for="state">Województwo</label>

                            <div class="col-md-8">
                                <sf:input type="text" path="state" class="form-control" placeholder="Województwo"/>
                                <sf:errors path="state" cssClass="help-block" element="em"/>
                            </div>
                        </div>



                        <div class="form-group">
                            <label class="control-label col-md-4" for="state">Kraj</label>

                            <div class="col-md-8">
                                <sf:input type="text" path="country" class="form-control" placeholder="Kraj"/>
                                <sf:errors path="country" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                    <div class="form-group">
                        <div class="col-md-8 col-md-offset-4">

                            <button type="submit" class="btn btn-primary" name="_eventId_personal">
                                Cofnij - Dane kontaktowe
                            </button>

                            <button type="submit" class="btn btn-primary" name="_eventId_confirm">
                                Dalej
                            </button>

                        </div>
                    </div>



                    </sf:form>
                </div>
            </div>
        </div>

</div>


<%@include file="../shared/flows-footer.jsp" %>