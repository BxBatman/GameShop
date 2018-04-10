package com.springshop.test;

import com.springshop.backShop.dao.CartLineDAO;
import com.springshop.backShop.dao.ProductDAO;
import com.springshop.backShop.dao.UserDAO;
import com.springshop.backShop.dto.Cart;
import com.springshop.backShop.dto.CartLine;
import com.springshop.backShop.dto.Product;
import com.springshop.backShop.dto.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class CartLineTestCase {
    private static AnnotationConfigApplicationContext context;

    private static CartLineDAO cartLineDAO = null;
    private static ProductDAO productDAO = null;
    private static UserDAO userDAO = null;

    private Product product = null;
    private User user = null;
    private Cart cart = null;
    private CartLine cartLine = null;


    @BeforeClass
    public static void init(){
        context = new AnnotationConfigApplicationContext();
        context.scan("com.springshop.backShop");
        context.refresh();
        productDAO = (ProductDAO)context.getBean("productDAO");
        userDAO = (UserDAO)context.getBean("userDAO");
        cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
    }


    @Test
    public void testAddNewCartLine(){
        user = userDAO.getByEmail("bartek@gmail.com");
        cart = user.getCart();
        product = productDAO.get(2);

        cartLine = new CartLine();
        cartLine.setBuyingPrice(product.getUnitPrice());
        cartLine.setProductCount(cartLine.getProductCount()+1);
        cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
        cartLine.setAvailable(true);
        cartLine.setCartId(cart.getId());

        cartLine.setProduct(product);
        assertEquals("Nie udalo sie dodac karty",true,cartLineDAO.add(cartLine));

        cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
        cart.setCartLines(cart.getCartLines() + 1);
        assertEquals("Nie udalo sie aktualizowac karty",true,cartLineDAO.updateCart(cart));



    }
}
