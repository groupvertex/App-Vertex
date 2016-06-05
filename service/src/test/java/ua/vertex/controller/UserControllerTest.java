package ua.vertex.controller;

import entity.Route;
import entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ua.vertex.config.Application;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest("server.port:8080")
public class UserControllerTest {

    private RestTemplate restTemplate = new RestTemplate();
    private static final String URL = "http://localhost:8080/users";

    private long USER_ID;

    private User TEST_USER;

    @Before
    public void init() {
        TEST_USER = new User(1, "firstName", "lastName", "test@gmail.com", "password");
        USER_ID = restTemplate.postForObject(URL, TEST_USER, Long.class);
        TEST_USER.setId(USER_ID);
    }

    @After
    public void clear() {
        restTemplate.delete(URL + "/" + USER_ID);
    }

    @Test
    public void createDuplicate() throws Exception {
        User duplicate = new User(1, "firstName", "lastName", "test@gmail.com", "password");
        long duplicateId = restTemplate.postForObject(URL, duplicate, Long.class);
        assertNotEquals(USER_ID, duplicateId);
        restTemplate.delete(URL + "/" + duplicateId);
    }

    @Test
    public void getExisted() throws Exception {
        User actual = restTemplate.getForObject(URL + "/" + USER_ID, User.class);
        assertEquals(TEST_USER, actual);
    }

    @Test(expected = HttpClientErrorException.class)
    public void getNotExisted() throws Exception {
        restTemplate.getForObject(URL + "/" + ThreadLocalRandom.current().nextInt(), User.class);
    }

    @Test
    public void update() throws Exception {
        TEST_USER.setId(ThreadLocalRandom.current().nextInt());
        TEST_USER.setEmail("updateEmail@gmail.com");
        restTemplate.put(URL + "/" + USER_ID, TEST_USER);

        User actual = restTemplate.getForObject(URL + "/" + USER_ID, User.class);
        assertEquals("updateEmail@gmail.com", actual.getEmail());
        assertEquals(USER_ID, actual.getId());
    }

    @Test(expected = HttpClientErrorException.class)
    public void deleteTwice() throws Exception {
        restTemplate.delete(URL + "/" + USER_ID);
        restTemplate.delete(URL + "/" + USER_ID);
        restTemplate.getForObject(URL + "/" + USER_ID, Route.class);
    }
}