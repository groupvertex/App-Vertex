package ua.vertex.controller;

import entity.HeaderRequestInterceptor;
import entity.User;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ua.vertex.config.Application;
import entity.AuthenticationRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest("server.port:8081")
public class UserControllerTest {

    private static RestTemplate restTemplate = new RestTemplate();
    private static final String SIGN_UP_URL = "http://localhost:8081/signup";
    private static final String AUTH_URL = "http://localhost:8081/auth";
    private static final String USER_URL = "http://localhost:8081/users/";

    private static User user;
    private static String authToken;


    @AfterClass
    public static void cleanUp() throws Exception {
        deleteUser();
    }


    private static void deleteUser() throws Exception {
        restTemplate.delete(USER_URL + user.getId());
    }

    @Test
    public void signUp() {
        user = new User(1234567890, "tested", "tested", "test@mail.ru", "test");
        Long id = restTemplate.postForObject(SIGN_UP_URL, user, Long.class);
        user.setId(id);
        authenticate();
    }

    private void authenticate() {
        AuthenticationRequest request = new AuthenticationRequest(user.getUsername(), user.getPassword());
        String token = restTemplate.postForObject(AUTH_URL, request, String.class);
        authToken = token;
        setHeaders();
    }

    private void setHeaders() {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Authorization", authToken));
        restTemplate.setInterceptors(interceptors);
    }

    @Test(expected = HttpClientErrorException.class)
    public void get_not_my_user() throws Exception {
        restTemplate.getForObject(USER_URL + user.getId() + 1, User.class);
    }

    @Test
    public void get_with_normal_credentials() throws Exception {
        User actual = restTemplate.getForObject(USER_URL + user.getId(), User.class);
        user.setPassword(actual.getPassword());
        assertEquals(user, actual);
    }
    
    @Test
    public void updateUser() throws Exception {
        user.setFirstName("testUpdate");
        restTemplate.put(USER_URL + user.getId(), user);

        User afterUpdate = restTemplate.getForObject(USER_URL + user.getId(), User.class);
        user.setPassword(afterUpdate.getPassword());
        assertEquals(user, afterUpdate);
    }


    @Test(expected = HttpClientErrorException.class)
    public void delete_not_my_user() throws Exception {
        restTemplate.delete(USER_URL + -1);
    }
}