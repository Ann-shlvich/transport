package com.htp;

import com.htp.dao.UserRepository;
import com.htp.domain.User;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TestUser {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository repository;

    /*@AfterEach
    public void resetDb() {
        repository.deleteAll();
    }*/

    @Test
    public void whenCreatePerson() {

        //User person = new User(,"Michail","Vacov", "Ufdin","mih@gmail.com","444444");

        User user =new User();
        user.setUsername("Michail");
        user.setSurname("Vacov");
        user.setPatronymic("Ufdin");
        user.setEmail("mih@gmail.com");
        user.setPassword("444444");
        user.setActive(true);
        user.setPassportSeriesNumber("KH5555555");
        user.setRegistrationAddress("Minsk");
        //ResponseEntity<User> response = restTemplate.postForEntity("/registration", user, User.class);

       /* assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
        assertThat(response.getBody().getId(), notNullValue());
        assertThat(response.getBody().getName(), is("Michail"));*/
    }

}
