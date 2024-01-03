package ru.sberbank.edu;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/finance", consumes = MediaType.ALL_VALUE)
public class ViewController{
    @GetMapping()
    public String finance(){
        return "finance.html";
    }

    @PostMapping
    public String result(

    ){
        return "finance.html";
    }
}