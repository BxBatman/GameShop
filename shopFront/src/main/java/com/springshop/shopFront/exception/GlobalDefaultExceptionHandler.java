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
         mv.addObject("errorDescription","Prawdopodobnie strona której szukasz nie istnieje");
         mv.addObject("title","404 b³±d");


         return mv;

    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handlerNoProductFoundException(){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorTitle","Produkt niedostêpny");
        mv.addObject("errorDescription","Prawdopodobnie produkt którego szukasz jest niedostêpny");
        mv.addObject("title","Produkt niedostêpny");


        return mv;

    }



    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception ex){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorTitle","Skontaktuj siê z admininstratorem");

        /*debugowanie tylko*/
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        ex.printStackTrace(pw);


        mv.addObject("errorDescription",ex.toString());
        mv.addObject("title","B³±d");


        return mv;

    }



}
