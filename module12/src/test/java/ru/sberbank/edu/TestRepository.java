package ru.sberbank.edu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import ru.edu.module12.Application;
import ru.edu.module12.entity.User;
import ru.edu.module12.repository.UserRepository;
import java.util.Optional;

//@ContextConfiguration(classes = Application.class)
//@ExtendWith(MockitoExtension.class)
//@DataJpaTest
public class TestRepository {

    /*@Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

     */

    @Test
    public void saveAndFind() throws Exception {

        /*Assertions.assertTrue(userRepository.findAll().isEmpty());

        userRepository.saveAndFlush(new User(1,"Oleg", 11));

        Optional<User> bdUser = userRepository.findById(1);

        Assertions.assertFalse(bdUser.isEmpty());

         */

    }


}
