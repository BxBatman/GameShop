package com.springshop.shopFront.controller;

import com.springshop.backShop.dao.AddressDAO;
import com.springshop.backShop.dao.CartLineDAO;
import com.springshop.backShop.dao.ProductDAO;
import com.springshop.backShop.dao.UserDAO;
import com.springshop.backShop.dto.CartLine;
import com.springshop.backShop.dto.Product;
import com.springshop.backShop.dto.User;
import com.springshop.shopFront.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private CartLineDAO cartLineDAO;

    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/show")
    public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {
        ModelAndView mv = new ModelAndView("page");

        if (result != null) {
            switch (result) {
                case "updated":
                    mv.addObject("message", "Koszyk zaktualizowany");
                    break;
                case "added":
                    mv.addObject("message", "Dodano do koszyka");
                    break;
                case "deleted":
                    mv.addObject("message", "Usuniêto element");
                    break;
                case "maximum":
                    mv.addObject("message", "Osi±gniêto limit");
                    break;
                case "unavailable":
                    mv.addObject("message", "Brak wiêkszej ilo¶ci");
                    break;
                case "error":
                    mv.addObject("message", "Co¶ posz³o nie tak");
                    break;
            }
        }


        mv.addObject("title", "Koszyk");
        mv.addObject("userClickShowCart", true);
        mv.addObject("cartLines", cartService.getCartLines());
        mv.addObject("payResponse",cartService.checkUpdateSubtotal());
        return mv;
    }

    @RequestMapping("/{cartLineId}/update")
    public String updateCart(@PathVariable int cartLineId, @RequestParam int count) {
        String response = cartService.manageCartLine(cartLineId, count);
        return "redirect:/cart/show?" + response;
    }

    @RequestMapping("/{cartLineId}/delete")
    public String updateCart(@PathVariable int cartLineId) {
        String response = cartService.deleteCartLine(cartLineId);
        return "redirect:/cart/show?" + response;
    }

    @RequestMapping("/add/{productId}/product")
    public String addCart(@PathVariable int productId) {
        String response = cartService.addCartLine(productId);
        return "redirect:/cart/show?" + response;
    }

    @RequestMapping("/show/payment")
    public ModelAndView showPayment() {
        ModelAndView mv = new ModelAndView("page");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userDAO.getByEmail(authentication.getName());
        mv.addObject("title", "P³atno¶æ");
        mv.addObject("userClickShowPayment", true);
        mv.addObject("user",user);
        mv.addObject("address",addressDAO.getAddressByUserId(user.getId()));
        mv.addObject("cartLines", cartService.getCartLines());
        return mv;
    }

    @RequestMapping("/{cartId}/payout")
    public String deleteCartLines(@PathVariable int cartId) {
        List<CartLine> items = cartLineDAO.list(cartId);
        for (CartLine item : items) {
            cartService.deleteCartLine(item.getId());
            Product product = productDAO.get(item.getProduct().getId());
            if(product.getQuantity() > 0){
                product.setQuantity(product.getQuantity() - item.getProductCount());
                productDAO.update(product);
            }
        }
        return "redirect:/home";
    }

}
