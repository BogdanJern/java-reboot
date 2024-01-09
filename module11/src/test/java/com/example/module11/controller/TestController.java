package com.example.module11.controller;

import com.example.module11.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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

    @InjectMocks
    ObjectMapper mapper;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void allUsersPage() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/user/allUsers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("allUser.html"));
    }
    @Test
    public void getDelUserPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/delUser")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("delUser.html"));
    }

    @Test
    public void addDelUserPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/addUser")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("addUser.html"));
    }

    @Test
    public void chdDelUserPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/cngUser")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("cngUser.html"));
    }
}
