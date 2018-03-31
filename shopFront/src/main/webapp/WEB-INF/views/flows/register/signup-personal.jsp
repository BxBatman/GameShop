<%@ page contentType="text/html;charset=ISO-8859-2" language="java" pageEncoding="ISO-8859-2" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp" %>
<div class="container" style="width: 60%;" align="right">

        <div class="col-md-12 col-md-offset-4" align="center" >
            <div class="panel panel-primary">
                <div class="panel panel-heading">
                    <h4>Zarejestruj siê - Dane personalne</h4>
                </div>
                <div class="panel-body">
                    <sf:form method="POST" class="form-horizontal" id="registerForm" modelAttribute="user">
                    <div class="form-group" >
                        <label class="control-label col-md-4">Imie</label>
                        <div class="col-md-8">
                            <sf:input type="text" path="firstName" class="form-control" placeholder="Imie"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4">Nazwisko</label>
                        <div class="col-md-8">
                            <sf:input type="text" path="lastName" class="form-control" placeholder="Nazwisko"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-md-4">E-mail</label>
                        <div class="col-md-8">
                            <sf:input type="text" path="email" class="form-control"
                                      placeholder="example@example.com"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4">Numer telefonu</label>
                        <div class="col-md-8">
                            <sf:input type="text" path="contactNumber" class="form-control"
                                      placeholder="Nr.telefonu" maxlength="9"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-md-4">Has³o</label>
                        <div class="col-md-8">
                            <sf:input type="password" path="password" class="form-control"
                                      placeholder="Has³o"/>
                        </div>
                    </div>

                    <label class="control-label col-md-4">Rodzaj konta</label>
                    <div class="col-md-8">
                        <label class="radio-inline">
                            <sf:radiobutton path="role" value="USER" checked="checked"/>U¿ytkownik
                        </label>
                        <label class="radio-inline">
                            <sf:radiobutton path="role" value="SUPPLIER"/>Dostawca
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <div class="cold-md-offset-4 col-md-8">
                        <button type="submit" class="btn btn-primary" name="_eventId_billing">
                            Id¼ dalej
                        </button>
                    </div>
                </div>

                </sf:form>
            </div>
        </div>


</div>



<!-- /.container -->

<%@include file="../shared/flows-footer.jsp" %>
