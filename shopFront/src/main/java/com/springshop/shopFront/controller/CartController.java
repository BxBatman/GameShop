package com.springshop.shopFront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
@RequestMapping("/cart")
public class CartController {

    @RequestMapping("/show")
    public ModelAndView showCart(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","User Cart");
        mv.addObject("userClickShowCart",true);
        mv.addObject("cartLines",null);

        return mv;
    }
}
