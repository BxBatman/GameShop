<%@ page contentType="text/html;charset=ISO-8859-2" language="java" pageEncoding="ISO-8859-2"%>
<div class="container">
    <c:if test="${not empty message}">
        <div class="alert alert-info">
            <h3 class="text-center">
                ${message}
            </h3>
        </div>
    </c:if>


    <c:choose>

        <c:when test="${not empty cartLines}">
            <table id="cart" class="table table-hover table-condensed">
                <thead>
                <tr>
                    <th style="width:50%">Produkt</th>
                    <th style="width:10%">Cena</th>
                    <th style="width:8%">Ilo¶æ</th>
                    <th style="width:22%" class="text-center">Suma</th>
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
                                <div class="col-sm-8" style="margin-left: 20px">
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
                            <c:choose>
                                <c:when test="${cartLine.product.quantity > 0}">
                            <input type="number" id="count_${cartLine.id}" min="1"  max="3" class="form-control text-center" value="${cartLine.productCount}">
                                </c:when>
                                <c:otherwise>
                                    <h4 style="color: red">Wyprzedane</h4>
                                </c:otherwise>
                            </c:choose>

                        </td>
                        <td data-th="Subtotal" class="text-center">${cartLine.total} z³</td>
                        <td class="actions" data-th="">
                            <button type="button" name="refreshCart" value="${cartLine.id}" class="btn btn-info btn-sm"><i class="fa fa-refresh">Od¶wie¿</i></button>
                            <a href="${contextRoot}/cart/${cartLine.id}/delete" class="btn btn-danger btn-sm"><i class="fa fa-trash-o">Usuñ</i></a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
                <tfoot>
                <tr>
                    <td><a href="${contextRoot}/show/all/products" class="btn btn-warning"><i class="fa fa-angle-left"></i> Kontynuuj zakupy</a></td>
                    <td colspan="2" class="hidden-xs"></td>
                    <c:choose>
                    <c:when test="${not empty payResponse}">
                    <td class="hidden-xs text-center" style="color:red;"> <strong>Usuñ wyprzedane produkty aby zap³aciæ</strong></td>
                    <td><a href="" class="btn btn-success btn-block disabled">P³atno¶æ <i class="fa fa-angle-right"></i></a>
                        </c:when>
                        <c:otherwise>
                    <td class="hidden-xs text-center"><strong>Ca³kowity koszt ${userModel.cart.grandTotal} z³</strong></td>
                    <td><a href="${contextRoot}/cart/show/payment" class="btn btn-success btn-block">P³atno¶æ <i class="fa fa-angle-right"></i></a>
                        </c:otherwise>
                        </c:choose>
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