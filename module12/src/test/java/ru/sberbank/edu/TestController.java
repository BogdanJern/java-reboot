package ru.sberbank.edu;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.edu.module12.controller.UserController;
import ru.edu.module12.entity.User;
import ru.edu.module12.repository.UserRepository;
import ru.edu.module12.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = UserController.class)

@AutoConfigureMockMvc
public class TestController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;

    @MockBean
    UserService userService;

    @InjectMocks
    ObjectMapper mapper;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    @WithMockUser(username = "admin", password = "123456")
    public void allUsersPage() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/user/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("allUser.html"));
    }
    @Test
    @WithMockUser(username = "admin", password = "123456")
    public void getDelUserPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/del")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("delUser.html"));
    }

    @Test
    @WithMockUser(username = "admin", password = "123456")
    public void addDelUserPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/add")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("addUser.html"));
    }

    @Test
    @WithMockUser(username = "admin", password = "123456")
    public void chdDelUserPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/cng")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("cngUser.html"));
    }
}