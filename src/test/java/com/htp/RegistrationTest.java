package com.htp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before()
    public void setup() {
        //Init MockMvc Object and build
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
    }

    @Test
    public void testMainPageContext() throws Exception{
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Добро пожаловать")))
                .andExpect(content().string(containsString("Войти")))
                .andExpect(content().string(containsString("Зарегестироваться")));
    }
    @Test
    public void testRegistrationPageContext() throws Exception{
        this.mockMvc.perform(get("/registration")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Регистрация")))
                .andExpect(content().string(containsString("Зарегестрировать")));
    }

    @Test
    public void addUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/registration")
                        .param("email","user@gmail.com")
                .param("username","user")
                .param("surname","userUser")
                .param("patronymic","userUserUser")
                .param("password","111111")
                .param("dateOfBirth", String.valueOf(LocalDate.now()))
                .param("passportSeriesNumber","KH6767678")
                .param("registrationAddress","Grodno")
                /*.with(csrf())*/
                        .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));


    }


}
