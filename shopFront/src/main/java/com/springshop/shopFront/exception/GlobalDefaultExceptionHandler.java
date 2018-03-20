package com.springshop.shopFront.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handlerNoHandlerFoundException(){
         ModelAndView mv = new ModelAndView("error");
         mv.addObject("errorTitle","Nie znaleziono strony");
         mv.addObject("errorDescription","Prawdopodobnie strona kt�rej szukasz nie istnieje");
         mv.addObject("title","404 b��d");


         return mv;

    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handlerNoProductFoundException(){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorTitle","Produkt niedost�pny");
        mv.addObject("errorDescription","Prawdopodobnie produkt kt�rego szukasz jest niedost�pny");
        mv.addObject("title","Produkt niedost�pny");


        return mv;

    }



    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception ex){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorTitle","Skontaktuj si� z admininstratorem");

        /*debugowanie tylko*/
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        ex.printStackTrace(pw);


        mv.addObject("errorDescription",ex.toString());
        mv.addObject("title","B��d");


        return mv;

    }



}
