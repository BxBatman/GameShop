package com.springshop.shopFront.controller;


import com.springshop.backShop.dao.CategoryDAO;
import com.springshop.backShop.dao.ProductDAO;
import com.springshop.backShop.dto.Category;
import com.springshop.backShop.dto.Product;
import com.springshop.shopFront.util.FileUploadUtility;
import com.springshop.shopFront.validator.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManagementController {
    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ProductDAO productDAO;



    private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);


    @RequestMapping(value="/products",method= RequestMethod.GET)
    public ModelAndView showManageProducts(@RequestParam(name="operation",required = false) String operation){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickManageProducts",true);
        mv.addObject("title","Zarz±dzaj produktami");
        Product nProduct = new Product();

        nProduct.setSupplierId(1);
        nProduct.setActive(true);

        mv.addObject("product",nProduct);

        if(operation!=null){
            if(operation.equals("product")) {
                mv.addObject("message","Produkt dodany");
            }
        }

        return mv;
    }

    @RequestMapping(value="/products",method= RequestMethod.POST)
    public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model, HttpServletRequest request){


        new ProductValidator().validate(mProduct,results);




        if(results.hasErrors()) {
            model.addAttribute("userClickManageProducts",true);
            model.addAttribute("title","Manage Products");
            model.addAttribute("message1","Dodanie nie powiod³o siê");
            return "page";
        }

        logger.info(mProduct.toString());
        productDAO.add(mProduct);


        if(!mProduct.getFile().getOriginalFilename().equals("")){
            FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
        }


        return "redirect:/manage/products?operation=product";
    }



    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryDAO.list();
    }

}
