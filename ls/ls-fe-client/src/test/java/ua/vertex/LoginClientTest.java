package ua.vertex;

import entity.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.vertex.config.Application;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest("server.port:8081")
@ActiveProfiles("test")
public class LoginClientTest {

    private static LoginClient loginClient;

    @BeforeClass
    public static void init() {
        loginClient = new LoginClient();
    }


    @Test
    public void fullTest() {
        User tested = new User(1, "test", "test", "test@mail.ru", "test");
        long id = loginClient.signUp(tested);
        assertTrue(id != tested.getId());

        String token = loginClient.login(tested.getEmail(), tested.getPassword());
        assertTrue(loginClient.isValidToken(token));
    }

}