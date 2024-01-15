package ru.edu.module12.entity;

import jakarta.persistence.*;

/**
 * Строка пользователя из БД
 */
@Entity
@Table(name = "\"user\"")
public class User {

    /**
     * Ключ таблицы
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    /**
     * Имя пользователя
     */
    @Column(name = "name")
    private String name;
    /**
     * Возраст пользователя
     */
    @Column(name = "age")
    private Integer age;

    public User() {
    }

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
