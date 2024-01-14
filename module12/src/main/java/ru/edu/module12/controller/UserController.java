package ru.edu.module12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.edu.module12.entity.User;
import ru.edu.module12.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    /**
     * Отображение всех пользователей
     * @param model
     * @return
     */
    @GetMapping(value = "/allUsers")
    public String viewUsers(Model model) {
        //Получение всех пользователей
        List<User> users = userRepository.findAll();

        //Установка значений на страницу
        model.addAttribute("users", users);

        return "allUser.html";
    }
}
