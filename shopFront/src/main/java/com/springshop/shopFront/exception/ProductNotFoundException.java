package com.springshop.shopFront.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {
    private String message;
    private static final long serialVersionUID = 1L;
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public ProductNotFoundException(){
        this("Produkt nie jest dostêpny");
    }

    public ProductNotFoundException(String message){
        this.message = System.currentTimeMillis() + ": " + message;
    }
}
