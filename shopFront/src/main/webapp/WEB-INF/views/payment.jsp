<%@ page contentType="text/html;charset=ISO-8859-2" language="java" pageEncoding="ISO-8859-2"%>
<div class="container">
    <div class="row">
        <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <address>
                        <strong>${userModel.fullName}</strong>
                        <br>
                        2135 Sunset Blvd
                        <br>
                        Los Angeles, CA 90026
                        <br>
                        <abbr title="Phone">P:</abbr> (213) 484-6829
                    </address>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                    <p>
                        <em>Date: 1st November, 2013</em>
                    </p>
                    <p>
                        <em>Rachunek #: 34522677W</em>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="text-center">
                    <h1>Rachunek</h1>
                </div>
                </span>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Produkt</th>
                        <th>Ilo¶æ</th>
                        <th class="text-center">Cena</th>
                        <th class="text-center">Suma</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cartLines}" var="cartLine">
                    <tr>
                        <td class="col-md-9"><em>${cartLine.product.name}</em></td>
                        <td class="col-md-1" style="text-align: center"> ${cartLine.productCount} </td>
                        <td class="col-md-1 text-center">${cartLine.buyingPrice} z³</td>
                        <td class="col-md-1">${cartLine.total} z³</td>
                    </tr>

                    <tr>
                        <td>   </td>
                        <td>   </td>

                    </tr>
                    </c:forEach>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td class="text-right"><h4><strong>Kwota: </strong></h4></td>
                        <td class="text-center text-danger"><h4><strong>${userModel.cart.grandTotal} z³</strong></h4></td>
                    </tr>
                    </tbody>
                </table>
                <a href="${contextRoot}/cart/${userModel.cart.id}/payout" type="button" class="btn btn-success btn-lg btn-block">
                    Zap³aæ  <span class="glyphicon glyphicon-chevron-right"></span>
                </a></td>
            </div>
        </div>
    </div>