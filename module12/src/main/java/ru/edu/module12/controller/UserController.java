package ru.edu.module12.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.edu.module12.entity.User;
import ru.edu.module12.service.UserService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Отображение всех пользователей
     * @param model
     * @return
     */
    @GetMapping(value = "/all")
    public String viewAllUsers(Model model) {

        //Получение всех пользователей
        List<User> users = userService.findAll();

        //Установка значений на страницу
        model.addAttribute("users", users);

        return "allUser.html";
    }

    /**
     * Добавление пользователя
     * @param model
     * @return
     */
    @GetMapping(value = "/add")
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
    @PostMapping(value = "/add")
    public String addUser(@RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "age", required = true) String age,
                                Model model,
                                HttpServletResponse response) throws IOException {

        //Добавление пользователя в базу
        userService.addUser(name, age);

        //Перенаправляем на всех пользователей
        response.sendRedirect("/user/all");

        return null;
    }

    /**
     * Удаление пользователя
     * @param model
     * @return
     */
    @GetMapping(value = "/del")
    public String delUser(Model model) {
        return "delUser.html";
    }

    /**
     * Результат удаления пользователя
     * @param id
     * @param model
     * @return
     */
    @PostMapping(value = "/del")
    public String delUser(@RequestParam(value = "id", required = true) String id,
                          Model model,
                          HttpServletResponse response) throws IOException {

        User user;
        try {
            user = userService.delUser(id);
        }catch (IllegalArgumentException e){
            //Перенаправляем на страницу ошибки
            model.addAttribute("message", e.getMessage());
            return "error.html";
        }

        model.addAttribute("name", user.getName());
        model.addAttribute("age", user.getAge());

        return "resultDel.html";
    }

    /**
     * Изменение пользователя
     * @param model
     * @return
     */
    @GetMapping(value = "/cng")
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
    @PostMapping(value = "/cng")
    public String changeUser(@RequestParam(value = "id", required = true) String id,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "age", required = true) String age,
                             Model model) {

        User oldUser;

        try {
            oldUser = userService.changeUser(id, name, age);
        } catch (IllegalArgumentException e){
            //Перенаправляем на страницу ошибки
            model.addAttribute("message", e.getMessage());
            return "error.html";
        }

        //Установка ID на страницу
        model.addAttribute("id", oldUser.getId());

        //Установка старых значений на страницу
        model.addAttribute("oldName", oldUser.getName());
        model.addAttribute("oldAge", oldUser.getAge());

        //Установка новых значений на страницу
        model.addAttribute("newName", name);
        model.addAttribute("newAge", age);

        return "resultCng.html";
    }
}
