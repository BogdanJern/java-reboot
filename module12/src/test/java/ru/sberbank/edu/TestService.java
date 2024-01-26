package ru.sberbank.edu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.edu.module12.entity.User;
import ru.edu.module12.repository.UserRepository;
import ru.edu.module12.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestService {
    @Mock
    private UserRepository repository;

    private UserService service;

    @BeforeEach
    void setUp() {
        service = new UserService(repository);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void findAll() {
        User user1 = new User(1L, "Oleg", 11);
        User user2 = new User(2L, "Anna", 12);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        when(repository.findAll()).thenReturn(users);

        List<User> allUsers = service.findAll();
        Assertions.assertSame(allUsers, users);
    }

    @Test
    void add() {
        User user = new User(1L, "Oleg", 11);
        when(repository.save(any(User.class))).thenReturn(user);

        Assertions.assertEquals(user.getName(), service.addUser("Oleg", "11").getName());
        Assertions.assertEquals(user.getAge(), service.addUser("Oleg", "11").getAge());
    }
    @Test
    void deleteUser() {
        User user = new User(1L, "Oleg", 11);
        Optional<User> optionalUser = Optional.of(user);

        when(repository.findById(1L)).thenReturn(optionalUser);

        User delUser = service.delUser("1");

        Assertions.assertEquals(user, delUser);
    }

    @Test
    void updateUser() {

        User user = new User(1L, "Oleg", 11);
        Optional<User> optionalUser = Optional.of(user);

        when(repository.findById(1L)).thenReturn(optionalUser);

        User oldUser = service.changeUser("1","Anna","12");

        Assertions.assertNotEquals(user, oldUser);
        Assertions.assertEquals(user.getName(), "Anna");
        Assertions.assertEquals(user.getAge(), 12);

    }
}
