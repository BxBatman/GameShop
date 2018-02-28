package com.springshop.shopFront.controller;

import com.springshop.backShop.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = {"/","/home","/index"})
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","Strona G³ówna");
        mv.addObject("categories",categoryDAO.list());
        mv.addObject("userClickHome",true);
        return mv;
    }

    @RequestMapping(value = "/about")
    public ModelAndView about(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","O nas");
        mv.addObject("userClickAbout",true);
        return mv;
    }

    @RequestMapping(value = "/contact")
    public ModelAndView contact(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","Kontakt");
        mv.addObject("userClickContact",true);
        return mv;
    }

    //methods to load all products and based on categories

    @RequestMapping(value = "/show/all/products")
    public ModelAndView showAllProducts(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","Wszystkie produkty");
        mv.addObject("categories",categoryDAO.list());
        mv.addObject("userClickAllProducts",true);
        return mv;
    }

}
