package com.springshop.test;

import com.springshop.backShop.dao.ProductDAO;
import com.springshop.backShop.dto.Product;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class ProductTestCase {
    private static AnnotationConfigApplicationContext context;
    private static ProductDAO productDAO;

    private Product product;


    @BeforeClass
    public static void init(){
        context = new AnnotationConfigApplicationContext();
        context.scan("com.springshop.backShop");
        context.refresh();
        productDAO = (ProductDAO) context.getBean("productDAO");

    }


    @Test
    public void testCRUDProduct(){
        product = new Product();
        product.setName("Uncharted2");
        product.setBrand("PS3");
        product.setDescription("Przygodowka na ps3");
        product.setUnitPrice(120);
        product.setActive(true);
        product.setCategoryId(1);
        product.setSupplierId(2);


        assertEquals("Cos sie nie udalo przy dodawaniu produktu",false,productDAO.add(product));


        product = productDAO.get(3);
        product.setName("NFS 2015");

        assertEquals("Cos sie nie udalo przy AKTUALIZACJI produktu",false,productDAO.update(product));

        assertEquals("Cos sie nie udalo przy usuwaniu produktu",false,productDAO.delete(product));




    }
}
