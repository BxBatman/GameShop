<%@ page contentType="text/html;charset=ISO-8859-2" language="java" pageEncoding="ISO-8859-2" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp" %>
<div class="container" style="width: 60%;" align="center">

    <div class="col-sm-6">
        <div class="panel panel-primary">
            <div class="panel panel-heading">
                <h4>Dane personalne</h4>
            </div>
            <div class="panel-body">

            </div>
            <div class="panel-footer">
                <a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edytuj</a>
            </div>
        </div>
    </div>


    <div class="col-sm-6">
        <div class="panel panel-primary">
            <div class="panel panel-heading">
                <h4>Adres</h4>
            </div>
            <div class="panel-body">

            </div>
            <div class="panel-footer">
                <a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edytuj</a>
            </div>
        </div>
    </div>


    <div class="col-sm-6" style="padding-top: 20px">

        <a href="${flowExecutionUrl}&_eventId_success" class="btn btn-primary">Potwierd¼</a>

    </div>


</div>


<%@include file="../shared/flows-footer.jsp" %>