package com.example.module11.controller;

import com.example.module11.entity.User;
import com.example.module11.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/viewAllUsers")
    public String viewUsers(Model model) {
        List<User> users =  userRepository.findAll();
        model.addAttribute("users", users);

        return "allUser.html";
    }

    @GetMapping(value = "/addUser")
    public String addUser(Model model) {
        return "addUser.html";
    }
    @PostMapping(value = "/addUser")
    public String addUser(@RequestParam(value = "name", required = true) String name,
                          @RequestParam(value = "age", required = true) Integer age,
                          Model model) {

        User user = new User();
        user.setName(name);
        user.setAge(age);
        userRepository.save(user);

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "newUser.html";
    }

    @GetMapping(value = "/delUser")
    public String delUser(Model model) {
        return "delUser.html";
    }
    @PostMapping(value = "/delUser")
    public String delUser(@RequestParam(value = "id", required = true) Integer id,
                          Model model) {

        Optional<User> optional = userRepository.findById(id);
        User user = optional.get();
        userRepository.delete(user);

        model.addAttribute("name", user.getName());
        model.addAttribute("age", user.getAge());

        return "deletedUser.html";
    }

    @GetMapping(value = "/changeUser")
    public String changeUser(Model model) {
        return "changeUser.html";
    }

    @PostMapping(value = "/changeUser")
    public String changeUser(@RequestParam(value = "id", required = true) Integer id,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "age", required = true) Integer age,
                             Model model) {

        Optional<User> optional = userRepository.findById(id);
        User user = optional.get();
            user.setName(name);
            user.setAge(age);
            userRepository.save(user);

        model.addAttribute("name", user.getName());
        model.addAttribute("age", user.getAge());

        return "changedUser.html";
    }
}