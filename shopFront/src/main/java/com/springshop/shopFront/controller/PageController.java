package com.springshop.shopFront.controller;

import com.springshop.backShop.dao.CategoryDAO;
import com.springshop.backShop.dao.ProductDAO;
import com.springshop.backShop.dto.Category;
import com.springshop.backShop.dto.Product;
import com.springshop.shopFront.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import java.util.Collections;
import java.util.List;

@Controller
public class PageController {

    private static final Logger logger = LoggerFactory.getLogger(PageController. class);

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = {"/","/home","/index"})
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","Strona G��wna");

        logger.info("Inside PageController - INFO ");
        logger.debug("Inside PageController - DEBUG");

        mv.addObject("categories",categoryDAO.list());

        List<Product> shuffleProducts = productDAO.listActiveProducts();
        Collections.shuffle(shuffleProducts);


        mv.addObject("products",shuffleProducts);
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


    @RequestMapping(value = "/show/category/{id}/products")
    public ModelAndView showCategoryProducts(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("page");
        //category DAO to fetch a single factory

        Category category = null;
        category = categoryDAO.get(id);

        mv.addObject("title",category.getName());
        mv.addObject("categories",categoryDAO.list());
        mv.addObject("category",category);
        mv.addObject("userClickCategoryProducts",true);
        return mv;
    }

    @RequestMapping(value = "/show/{id}/product")
    public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
        ModelAndView mv = new ModelAndView("page");
        Product product = productDAO.get(id);

        if(product == null) throw new ProductNotFoundException();

        product.setViews(product.getViews()+1);
        productDAO.update(product);

        mv.addObject("title",product.getName());
        mv.addObject("product",product);

        mv.addObject("userClickShowProduct",true);


        return mv;
    }

    @RequestMapping(value = "/register")
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","Zarejestruj si�");
        return mv;
    }


    @RequestMapping("favicon.ico")
    String favicon() {

        return "forward:/resources/assets/favicon.ico";
    }


    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam(name="error",required = false)String error,@RequestParam(name="logout",required = false)String logout){
        ModelAndView mv = new ModelAndView("login");
        if(error!=null){
            mv.addObject("message","Niepoprawny login lub has�o");
        }
        if(logout!=null){
            mv.addObject("logout","Wylogowano poprawnie");
        }


        mv.addObject("title","Zaloguj si�");
        return mv;
    }


    @RequestMapping(value = "/access-denied")
    public ModelAndView accessDenied(){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("title","403 - access denied");
        mv.addObject("errorTitle","403-access denied");
        mv.addObject("errorDescription","403-access denied");
        return mv;
    }

    @RequestMapping(value = "/perform-logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null){
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
        return "redirect:/login?logout";
    }

}
