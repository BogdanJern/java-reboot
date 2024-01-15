package ru.edu.module12.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.edu.module12.entity.User;
import ru.edu.module12.repository.UserRepository;

import java.io.IOException;
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
    @GetMapping(value = "/all")
    public String viewAllUsers(Model model) {
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
    public ModelAndView addUser(@RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "age", required = true) Integer age,
                                Model model,
                                HttpServletResponse response) throws IOException {

        //Добавление пользователя в базу
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userRepository.save(user);

        //Установка значений на страницу
        model.addAttribute("name", name);
        model.addAttribute("age", age);

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
    public String delUser(@RequestParam(value = "id", required = true) Long id,
                          Model model,
                          HttpServletResponse response) {

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
    public String changeUser(@RequestParam(value = "id", required = true) Long id,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "age", required = true) Integer age,
                             Model model) {

        User user = new User();

        //Получение объекта из базы
        Optional<User> optional = userRepository.findById(id);
        user = optional.get();

        //Установка ID на страницу
        model.addAttribute("id", user.getId());

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
