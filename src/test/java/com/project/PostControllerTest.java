package com.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.entity.User;
import com.project.repository.AccountRepository;
import com.project.view.RegistrationForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @Transactional
    public void registrationTest() throws Exception {

        mockMvc.perform(post("/register")
                .param("email", "test@test")
                .param("firstName","test")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .characterEncoding("utf-8")
        ).andDo(print());

        User user = accountRepository.findUserByEmail("test@test");
        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.getFirstName(), "test");
    }
}
