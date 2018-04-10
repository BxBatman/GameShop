<%@ page contentType="text/html;charset=ISO-8859-2" language="java" pageEncoding="ISO-8859-2"%>
<div class="container">

    <c:choose>

        <c:when test="${not empty cartLines}">
            <table id="cart" class="table table-hover table-condensed">
                <thead>
                <tr>
                    <th style="width:50%">Product</th>
                    <th style="width:10%">Price</th>
                    <th style="width:8%">Quantity</th>
                    <th style="width:22%" class="text-center">Subtotal</th>
                    <th style="width:10%"></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${cartLines}" var="cartLine">
                    <tr>
                        <td data-th="Product">
                            <div class="row">
                                <div class="col-sm-2 hidden-xs"><img src="${images}/${cartLine.product.code}.jpg" alt="${cartLine.product.name}"
                                                                     class="img-responsive cartImg"/></div>
                                <div class="col-sm-10">
                                    <h4 class="nomargin">${cartLine.product.name}
                                    <c:if test="${cartLine.available == false}">
                                        <strong class="unavailable">(Niedostêpny)</strong>

                                    </c:if>
                                    </h4>
                                    <p>Wersja - ${cartLine.product.brand}</p>
                                    <p>Opis - ${cartLine.product.description}</p>
                                </div>
                            </div>
                        </td>
                        <td data-th="Price">${cartLine.buyingPrice} z³</td>
                        <td data-th="Quantity">
                            <input type="number" class="form-control text-center" value="${cartLine.productCount}">
                        </td>
                        <td data-th="Subtotal" class="text-center">${cartLine.total} z³</td>
                        <td class="actions" data-th="">
                            <button class="btn btn-info btn-sm"><i class="fa fa-refresh">Od¶wie¿</i></button>
                            <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o">Usuñ</i></button>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
                <tfoot>
                <tr class="visible-xs">
                    <td class="text-center"><strong>Ca³kowity koszt ${userModel.cart.grandTotal} z³ </strong></td>
                </tr>
                <tr>
                    <td><a href="#" class="btn btn-warning"><i class="fa fa-angle-left"></i> Kontynuuj zakupy</a></td>
                    <td colspan="2" class="hidden-xs"></td>
                    <td class="hidden-xs text-center"><strong>Ca³kowity koszt ${userModel.cart.grandTotal} z³</strong></td>
                    <td><a href="#" class="btn btn-success btn-block">P³atno¶æ <i class="fa fa-angle-right"></i></a>
                    </td>
                </tr>
                </tfoot>
            </table>
        </c:when>
        <c:otherwise>
            <div class="jumbotron">
                <div class="text-center">
                    <h1>Twój koszyk jest pusty</h1>
                </div>
            </div>
        </c:otherwise>
    </c:choose>


</div>