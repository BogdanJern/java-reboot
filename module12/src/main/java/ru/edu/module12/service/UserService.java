package ru.edu.module12.service;

import org.springframework.stereotype.Service;
import ru.edu.module12.entity.User;
import ru.edu.module12.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    /**
     * Управление пользователями
     */
    private final UserRepository userRepository;

    /**
     * конструктор
     * @param userRepository
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Возвращает список пользователей
     * @return
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Добавление пользователя
     * @param name
     * @param age
     * @return
     */
    public User addUser(String name, String age){

        int intAge;

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Пустое поле 'Имя'");
        }

        if (age.isEmpty()) {
            throw new IllegalArgumentException("Пустое поле 'Возраст'");
        }

        try{
            intAge = Integer.parseInt(age);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Неверный формат поля 'Возраст'", e);
        }

        //Добавление пользователя в базу
        User user = new User();
        user.setName(name);
        user.setAge(intAge);
        userRepository.save(user);
        return user;
    }

    /**
     * Удаление пользователя по Id
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    public User delUser(String id) throws IllegalArgumentException{

        long lId;

        try{
            lId = Long.parseLong(id);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Неверный формат поля 'Id'", e);
        }

        Optional<User> optional = userRepository.findById(lId);
        if (optional.isEmpty()){
            throw new IllegalArgumentException("Пользователь с Id: "+ id +" отсутствует");
        }

        User user = optional.get();
        userRepository.delete(user);
        return user;
    }

    /**
     * Изменение пользователя
     * @param id
     * @param name
     * @param age
     * @return Возвращает старые значения
     */
    public User changeUser(String id, String name, String age) throws IllegalArgumentException{

        User oldUser = new User();
        User user;
        long lId;
        int intAge;

        try{
            lId = Long.parseLong(id);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Неверный формат поля 'Id'", e);
        }

        Optional<User> optional = userRepository.findById(lId);
        if (optional.isEmpty()){
            throw new IllegalArgumentException("Пользователь с Id: "+ id +" отсутствует");
        }

        try{
            intAge = Integer.parseInt(age);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Неверный формат поля 'Возраст'", e);
        }

        user = optional.get();

        oldUser.setId(user.getId());
        oldUser.setName(user.getName());
        oldUser.setAge(user.getAge());

        //Сохранение новых значений
        user.setName(name);
        user.setAge(intAge);
        userRepository.save(user);

        return oldUser;
    }
}
