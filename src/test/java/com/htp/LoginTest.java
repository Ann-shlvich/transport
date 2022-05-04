package com.htp;

import com.htp.controller.MainController;
import com.htp.domain.User;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.containsString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {
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
    public void testLoginPageContext() throws Exception{
        this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Электронная почта")))
                .andExpect(content().string(containsString("Пароль")));
    }

    @Test
    public void correctLoginTest1() throws Exception {
        /*SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken( "annyta20005super@gmail.com", "666666"));*/
        mockMvc.perform(get("/main"))
                .andExpect(redirectedUrl("http://localhost/login"))
                .andExpect(content().string(containsString("Выберети форму")));

    }




    /*@Test
    public void shouldCreateUser() throws Exception {
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
    }*/





}
