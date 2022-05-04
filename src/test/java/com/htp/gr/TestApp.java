package com.htp.gr;

import com.htp.controller.MainController;
import com.htp.domain.User;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestApp {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MainController mainController;
    @AfterEach
    public void resetDb() {

    }

    @Test
    public void testMainPageContext() throws Exception{
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Добро пожаловать")))
                .andExpect(content().string(containsString("Войти")))
                .andExpect(content().string(containsString("Зарегестироваться")));
    }

    @Test
    public void shouldUser() throws Exception {
        User user = new User();
        user.setUsername("Michail");
        user.setSurname("Vacov");
        user.setPatronymic("Ufdin");
        user.setEmail("mih@gmail.com");
        user.setPassword("444444");
        user.setActive(true);
        user.setPassportSeriesNumber("KH5555555");
        user.setRegistrationAddress("Minsk");
        assertThat(user.getUsername()).isNotNull();
    }


    @Test
    public void shouldDrivers() throws Exception {

    }
    @Test
    public void editDriver() throws Exception {

    }

    @Test
    public void deleteDriver() throws Exception {

    }
    @Test
    public void foundDriverById() throws Exception {

    }


    @Test
    public void shouldRouters() throws Exception {

    }
    @Test
    public void editRouter() throws Exception {

    }

    @Test
    public void deleteRouter() throws Exception {

    }

    @Test
    public void foundRouterById() throws Exception {

    }

    @Test
    public void choiseForm() throws Exception {

    }
    @Test
    public void registration() throws Exception {

    }

    @Test
    public void filter() throws Exception {

    }












}

