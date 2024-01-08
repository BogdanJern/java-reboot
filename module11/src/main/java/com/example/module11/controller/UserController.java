package com.example.module11.controller;

import com.example.module11.entity.User;
import com.example.module11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping(value = "/viewUsers")
    public ModelAndView viewUsers() {
        User user = new User(1, "Oleg", 11);
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.findAll();


        users.add(user);
        modelAndView.setViewName("view-users");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
