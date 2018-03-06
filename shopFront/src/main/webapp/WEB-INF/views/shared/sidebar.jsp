<%@ page contentType="text/html;charset=ISO-8859-2" language="java" pageEncoding="ISO-8859-2" %>

<h1 class="my-1">Games4u</h1>
<div class="list-group">
    <c:forEach items="${categories}" var="category">
        <a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id="a_${category.name}">${category.name}</a>
    </c:forEach>

</div>