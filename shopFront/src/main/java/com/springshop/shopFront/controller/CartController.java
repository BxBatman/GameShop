package com.springshop.shopFront.controller;

import com.springshop.shopFront.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/show")
    public ModelAndView showCart(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","Koszyk");
        mv.addObject("userClickShowCart",true);
        mv.addObject("cartLines",cartService.getCartLines());

        return mv;
    }
}
