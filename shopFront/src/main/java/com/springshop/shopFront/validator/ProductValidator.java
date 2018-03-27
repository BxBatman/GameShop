package com.springshop.shopFront.validator;

import com.springshop.backShop.dto.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        if (product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
            errors.rejectValue("file", null, "Proszê wybraæ obraz do dodania");
            return;
        }
        if (!(product.getFile().getContentType().equals("image/jpeg") ||
                product.getFile().getContentType().equals("image/png") ||
                product.getFile().getContentType().equals("image/gif")
        )) {
           errors.rejectValue("file",null,"Proszê u¿ywaæ tylko obrazów");
           return;
        }

    }
}
