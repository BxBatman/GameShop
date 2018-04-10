package com.springshop.shopFront.controller;

import com.springshop.backShop.dao.UserDAO;
import com.springshop.backShop.dto.User;
import com.springshop.shopFront.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalController {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserDAO userDAO;

    private UserModel userModel = null;

    @ModelAttribute("userModel")
    @Transactional
    public UserModel getUserModel() {
        if (session.getAttribute("userModel") == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = userDAO.getByEmail(authentication.getName());
            if (user != null) {
                userModel = new UserModel();
                userModel.setId(user.getId());
                userModel.setEmail(user.getEmail());
                userModel.setRole(user.getRole());
                userModel.setFullName(user.getFirstName() + " " + user.getLastName());

                if(userModel.getRole().equals("USER")){
                    userModel.setCart(user.getCart());
                }

                session.setAttribute("userModel",userModel);
                return userModel;
            }
        }
        return (UserModel) session.getAttribute("userModel");
    }
}
