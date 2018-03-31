package com.springshop.shopFront.handler;

import com.springshop.backShop.dao.UserDAO;
import com.springshop.backShop.dto.Address;
import com.springshop.backShop.dto.Cart;
import com.springshop.backShop.dto.User;
import com.springshop.shopFront.model.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {
    @Autowired
    private UserDAO userDAO;

    public RegisterModel init(){
        return new RegisterModel();
    }

    public void addUser(RegisterModel registerModel,User user){
        registerModel.setUser(user);
    }
    public void addBilling(RegisterModel registerModel,Address billing){
        registerModel.setBilling(billing);
    }

    public String saveAll(RegisterModel registerModel){
        String transitionValue = "success";

        User user = registerModel.getUser();
        if(user.getRole().equals("USER")){
            Cart cart = new Cart();
            cart.setUser(user);
            user.setCart(cart);
        }

        userDAO.addUser(user);

        Address billing = registerModel.getBilling();

        billing.setUser(user);

        billing.setBilling(true);

        userDAO.addAddress(billing);


        return transitionValue;
    }
}
