package com.example.module11.entity;

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
    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}