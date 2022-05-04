package com.htp;

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

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestApp {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MainController mainController;



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
        this.mockMvc.perform(get("/userList")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Список заявок на регистрацию водителей")));

    }


    @Test
    public void shouldDrivers() throws Exception {
        this.mockMvc.perform(get("/driverList")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Список заявок на регистрацию водителей")));
    }


    @Test
    public void editDriver() throws Exception {
        mockMvc.perform(post("/saveDriver")
                .param("id","1")
                .param("fullName","hi")
                .param("driverLicenseNumber","567656765465")
                .param("dateOfConclusion",String.valueOf(LocalDate.now()))
                .param("lengthOfAContract",String.valueOf(LocalDate.now()))
                .param("experience","noExperience")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

    }

    @Test
    public void deleteDriver() throws Exception {
        this.mockMvc.perform(post("/driver/1")).andDo(print()).andExpect(status().isOk());

    }



    @Test
    public void shouldRouters() throws Exception {
        this.mockMvc.perform(get("/routeList")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Список заявок на регистрацию маршрута")));

    }
    @Test
    public void editRouter() throws Exception {
        mockMvc.perform(post("/saveRoute")
                .param("id","1")
                .param("dateOfSetupRoute",String.valueOf(LocalDate.now()))
                .param("lastChangeDate",String.valueOf(LocalDate.now()))
                .param("typeOfTransport","Автобус")
                .param("numberOfStops","10")
                .param("startPoint","Рафиева")
                .param("direction","Рафиева")
                .param("endPoint","Рафиева")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    @Test
    public void deleteRouter() throws Exception {
        this.mockMvc.perform(post("/route/1")).andDo(print()).andExpect(status().isOk());

    }



    @Test
    public void filter() throws Exception {
        this.mockMvc.perform(get("/driver")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Список заявок на регистрацию водителя")));

    }












}

