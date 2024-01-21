package ru.sberbank.edu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.edu.module12.entity.User;
import ru.edu.module12.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class TestRepository {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void saveAll() throws Exception {

        List<User> users = new ArrayList<>();

        Assertions.assertEquals(userRepository.findAll(),users);

        User user1 = new User(1L,"Oleg", 11);
        User user2 = new User(2L,"Anna", 12);
        users.add(user1);
        users.add(user2);

        userRepository.saveAllAndFlush(users);

        Assertions.assertEquals(userRepository.findAll(),users);

    }
}
