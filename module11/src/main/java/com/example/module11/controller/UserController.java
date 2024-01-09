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

    /**
     * Добавление пользователя
     * @param model
     * @return
     */
    @GetMapping(value = "/addUser")
    public String addUser(Model model) {
        return "addUser.html";
    }

    /**
     * Результат добавления пользователя
     * @param name
     * @param age
     * @param model
     * @return
     */
    @PostMapping(value = "/addUser")
    public String addUser(@RequestParam(value = "name", required = true) String name,
                          @RequestParam(value = "age", required = true) Integer age,
                          Model model) {

        //Добавление пользователя в базу
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userRepository.save(user);

        //Установка значений на страницу
        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "resultAdd.html";
    }

    /**
     * Удаление пользователя
     * @param model
     * @return
     */
    @GetMapping(value = "/delUser")
    public String delUser(Model model) {
        return "delUser.html";
    }

    /**
     * Результат удаления пользователя
     * @param id
     * @param model
     * @return
     */
    @PostMapping(value = "/delUser")
    public String delUser(@RequestParam(value = "id", required = true) Integer id,
                          Model model) {

        Optional<User> optional = userRepository.findById(id);
        User user = optional.get();
        userRepository.delete(user);

        model.addAttribute("name", user.getName());
        model.addAttribute("age", user.getAge());

        return "resultDel.html";
    }

    /**
     * Изменение пользователя
     * @param model
     * @return
     */
    @GetMapping(value = "/cngUser")
    public String changeUser(Model model) {
        return "cngUser.html";
    }

    /**
     * Результат изменения пользователя
     * @param id
     * @param name
     * @param age
     * @param model
     * @return
     */
    @PostMapping(value = "/cngUser")
    public String changeUser(@RequestParam(value = "id", required = true) Integer id,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "age", required = true) Integer age,
                             Model model) {

        User user = new User();

        //Получение объекта из базы
        Optional<User> optional = userRepository.findById(id);
        user = optional.get();

        //Установка ID на страницу
        model.addAttribute("id", user.getName());

        //Установка старых значений на страницу
        model.addAttribute("oldName", user.getName());
        model.addAttribute("oldAge", user.getAge());

        //Установка новых значений на страницу
        model.addAttribute("newName", name);
        model.addAttribute("newAge", age);

        //Сохранение новых значений
        user.setName(name);
        user.setAge(age);
        userRepository.save(user);

        return "resultCng.html";
    }
}