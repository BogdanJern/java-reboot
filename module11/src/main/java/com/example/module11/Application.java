package com.example.module11;

import com.example.module11.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Application {

    @Autowired
    static UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
