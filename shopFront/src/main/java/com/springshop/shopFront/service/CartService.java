package com.springshop.shopFront.service;

import com.springshop.backShop.dao.CartLineDAO;
import com.springshop.backShop.dto.Cart;
import com.springshop.backShop.dto.CartLine;
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
    private HttpSession session;

    //return cart of the ser who is logged in
    private Cart getCart(){
        return ((UserModel)session.getAttribute("userModel")).getCart();
    }


    //return the entire cart lines
    public List<CartLine> getCartLines(){
        return cartLineDAO.list(this.getCart().getId());
    }


}
