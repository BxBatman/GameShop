<%@ page contentType="text/html;charset=ISO-8859-2" language="java" pageEncoding="ISO-8859-2" %>
<div class="container">

    <div class="row">
        <div class="col-xs-12">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextRoot}/home">Strona g³ówna</a></li>
                <li class="breadcrumb-item"><a href="${contextRoot}/show/all/products">Produkty</a></li>
                <li class="breadcrumb-item active">${product.name}</li>
            </ol>
        </div>
    </div>


    <div class="row">
        <div class="col-xs-12 col-sm-4">
            <div class="thumbnail">
                <img src="${images}/${product.code}.jpg" class="singleProductImg"/>
            </div>
        </div>

        <div class="col-xs-12 col-sm-8">
            <h3>${product.name}</h3>
            <hr/>
            <p>${product.description}</p>
            <hr/>
            <h4>Cena: <strong> ${product.unitPrice} z³</strong></h4>
            <h6>Ilo¶æ: ${product.quantity}</h6>

            <a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">Dodaj do koszyka</a>
            <a href="${contextRoot}/show/all/products" class="btn btn-primary">Cofnij</a>


        </div>
    </div>

</div>