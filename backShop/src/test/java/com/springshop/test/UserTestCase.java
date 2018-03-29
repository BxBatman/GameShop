package com.springshop.test;

import com.springshop.backShop.dao.UserDAO;
import com.springshop.backShop.dto.Address;
import com.springshop.backShop.dto.Cart;
import com.springshop.backShop.dto.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class UserTestCase {
    private static AnnotationConfigApplicationContext context;
    private static UserDAO userDAO;
    private User user = null;
    private Cart cart = null;
    private Address address = null;


    @BeforeClass
    public static void init(){
        context = new AnnotationConfigApplicationContext();
        context.scan("com.springshop.backShop");
        context.refresh();

        userDAO = (UserDAO) context.getBean("userDAO");
    }

    @Test
    public void testAdd() {
        user = new User();
        user.setFirstName("Bartek");
        user.setFirstName("Wysocki");
        user.setEmail("bartek@gmail.com");
        user.setContactNumber("123456789");
        user.setRole("USER");
        user.setPassword("123456");

        assertEquals("Nie udalo sie dodac uzytkownika",true,userDAO.addUser(user));

        address = new Address();
        address.setAddressLineOne("Kwiatowa 6");
        address.setAddressLineTwo("obok Świebodzin");
        address.setCity("Świebodzin");
        address.setState("Pomorskie");
        address.setCountry("Polska");
        address.setPostalCode("40560");
        address.setBilling(true);


        address.setUserId(user.getId());


        assertEquals("Nie udalo sie dodac adresu",true,userDAO.addAddress(address));

        if(user.getRole().equals("USER")){
            //create cart
            cart = new Cart();
            cart.setUserId(user.getId());
            assertEquals("Nie udalo sie dodac karty",true,userDAO.addCart(cart));


            address = new Address();
            address.setAddressLineOne("Kwiatowa 6");
            address.setAddressLineTwo("obok Świebodzin");
            address.setCity("Świebodzin");
            address.setState("Pomorskie");
            address.setCountry("Polska");
            address.setPostalCode("40560");
            address.setShipping(true);

            address.setUserId(user.getId());

            assertEquals("Problem z dodaniem adresu wysylki",true,userDAO.addAddress(address));

        }


    }
}
