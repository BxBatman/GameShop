package com.springshop.shopFront.service;

import com.springshop.backShop.dao.CartLineDAO;
import com.springshop.backShop.dao.ProductDAO;
import com.springshop.backShop.dto.Cart;
import com.springshop.backShop.dto.CartLine;
import com.springshop.backShop.dto.Product;
import com.springshop.shopFront.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("cartService")
public class CartService {

    @Autowired
    private CartLineDAO cartLineDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private HttpSession session;

    //return cart of the ser who is logged in
    private Cart getCart(){
        return ((UserModel)session.getAttribute("userModel")).getCart();
    }


    //return the entire cart lines
    public List<CartLine> getCartLines(){
        return cartLineDAO.list(this.getCart().getId());
    }

    public String manageCartLine(int cartLineId,int count){

        CartLine cartLine = cartLineDAO.get(cartLineId);
        if(cartLine == null){
            return "result=error";
        }
        else {
            Product product = cartLine.getProduct();
            double oldTotal = cartLine.getTotal();


            if(product.getQuantity() < count){
                return "result=unavailable";
            }
            cartLine.setProductCount(count);
            cartLine.setBuyingPrice(product.getUnitPrice());

            cartLine.setTotal(product.getUnitPrice() * count);

            cartLineDAO.update(cartLine);

            Cart cart = this.getCart();

            cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());

            cartLineDAO.updateCart(cart);

            return "result=updated";
        }
    }


    public String deleteCartLine(int cartLineId) {
        CartLine cartLine = cartLineDAO.get(cartLineId);
        if(cartLine == null){
            return "result=error";
        }else {
            Cart cart = this.getCart();
            cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
            cart.setCartLines(cart.getCartLines() - 1);
            cartLineDAO.updateCart(cart);


            cartLineDAO.delete(cartLine);

            return "result=deleted";

        }
    }

    public String addCartLine(int productId) {
        String response = null;

        Cart cart = this.getCart();

        CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(),productId);

        if(cartLine == null){
            cartLine = new CartLine();
            Product product = productDAO.get(productId);

            cartLine.setCartId(cart.getId());

            cartLine.setProduct(product);

            cartLine.setBuyingPrice(product.getUnitPrice());

            cartLine.setProductCount(1);

            cartLine.setTotal(product.getUnitPrice());
            cartLine.setAvailable(true);

            cartLineDAO.add(cartLine);

            cart.setCartLines(cart.getCartLines() + 1);
            cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());

            cartLineDAO.updateCart(cart);

            response = "result=added";

        }else {
            if(cartLine.getProductCount() < 3) {
                response = this.manageCartLine(cartLine.getId(),cartLine.getProductCount() + 1);
            }else {
                response = "result=maximum";
            }
        }


        return response;
    }

    public String checkUpdateSubtotal() {
        String response = null;
        List<CartLine> cartLineList = getCartLines();
        for (CartLine cartLine : cartLineList) {
            if(cartLine.getProduct().getQuantity() < 1) {
                response = "expired";
            }
        }
        return response;
    }
}
