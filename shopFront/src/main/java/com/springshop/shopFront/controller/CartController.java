package com.springshop.shopFront.controller;

import com.springshop.shopFront.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

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


}
