package com.htp;

import com.htp.controller.UserController;
import com.htp.dao.UserRepository;
import com.htp.domain.User;
import com.htp.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class UserTest {

    private MockMvc mockMvc;
    @InjectMocks
    UserController userController;
    @Mock
    UserService userService;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .build();
    }
    @Test
    public void editUser() throws Exception {

    }

    @Test
    public void getAllItems() throws Exception {
            User user = new User();
            user.setUsername("Michail");
            user.setSurname("Vacov");
            user.setPatronymic("Ufdin");
            user.setEmail("mih@gmail.com");
            user.setPassword("444444");
            user.setActive(true);
            user.setPassportSeriesNumber("KH5555555");
            user.setRegistrationAddress("Minsk");
        List<User> items = Arrays.asList(user);
        Mockito.when(userService.findAll()).thenReturn(items);
        mockMvc.perform(MockMvcRequestBuilders.get("/user"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    public void deleteUser() throws Exception {

    }
    @Test
    public void getItem() throws Exception{
        User user = new User();
        user.setId(90l);
        user.setUsername("Michail");
        user.setSurname("Vacov");
        user.setPatronymic("Ufdin");
        user.setEmail("mih@gmail.com");
        user.setPassword("444444");
        user.setActive(true);
        user.setPassportSeriesNumber("KH5555555");
        user.setRegistrationAddress("Minsk");
        Mockito.when(userService.findByEmail("mih@gmail.com")).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .accept(MediaType.APPLICATION_JSON));
                //.andExpect(MockMvcResultMatchers.status().isOk())
              //  .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(90l)))
              //  .andExpect(MockMvcResultMatchers.jsonPath("$.name",Matchers.is("Michail")))
              //  .andExpect(MockMvcResultMatchers.jsonPath("$.email",Matchers.is("mih@gmail.com")));
        //Mockito.verify(userService).findById(90L);
    }


    @Test
    public void foundUserById() throws Exception {

    }

}
