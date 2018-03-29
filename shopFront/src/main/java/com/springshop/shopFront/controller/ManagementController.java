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
import org.springframework.web.bind.annotation.*;
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
            }else if(operation.equals("category")){
                mv.addObject("message","Kategoria dodana");
            }
        }

        return mv;
    }



    @RequestMapping(value = "/{id}/product",method=RequestMethod.GET)
    public ModelAndView showEditProducts(@PathVariable int id){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickManageProducts",true);
        mv.addObject("title","Zarz±dzaj produktami");
        Product nProduct = productDAO.get(id);
        mv.addObject("product",nProduct);
        return mv;
    }





    @RequestMapping(value="/products",method= RequestMethod.POST)
    public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model, HttpServletRequest request){

        if(mProduct.getId() == 0){
            new ProductValidator().validate(mProduct,results);
        }else {
            if(!mProduct.getFile().getOriginalFilename().equals("")){
                new ProductValidator().validate(mProduct,results);
            }
        }





        if(results.hasErrors()) {
            model.addAttribute("userClickManageProducts",true);
            model.addAttribute("title","Manage Products");
            model.addAttribute("message1","Dodanie nie powiod³o siê");
            return "page";
        }

        logger.info(mProduct.toString());


        if(mProduct.getId() == 0) {
            productDAO.add(mProduct);
        }else {
            productDAO.update(mProduct);
        }


        if(!mProduct.getFile().getOriginalFilename().equals("")){
            FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
        }


        return "redirect:/manage/products?operation=product";
    }



    @RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
    @ResponseBody
    public String handleProductActivation(@PathVariable int id){
        Product product = productDAO.get(id);
        boolean isActive = product.isActive();

        product.setActive(!product.isActive());

        productDAO.update(product);


        return (isActive)? "Deaktywacja produktu " + product.getName() : "Aktywacja produktu  " + product.getName();
    }

    @RequestMapping(value="/category",method=RequestMethod.POST)
    public String handleCategorySubmission(@ModelAttribute Category category){
        categoryDAO.add(category);
        return "redirect:/manage/products?operation=category";
    }



    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryDAO.list();
    }

    @ModelAttribute("category")
    public Category getCategory(){
        return new Category();
    }

}
