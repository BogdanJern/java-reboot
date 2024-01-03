package ru.sberbank.edu.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/finance", consumes = MediaType.ALL_VALUE)
public class ViewController{
    @GetMapping()
    public String finance(){
        return "ru/sberbank/edu/finance.html";
        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("/finance.html");
        //return modelAndView;
    }

    @PostMapping
    public String financePage(){
        return "ru/sberbank/edu/finance.html";
    }
}