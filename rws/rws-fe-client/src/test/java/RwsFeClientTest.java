import entity.Route;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.vertex.Application;

import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest("server.port:8002")
public class RwsFeClientTest {


    @Test
    public void addRoute() throws Exception {
        RwsFeClient client = new RwsFeClient();
        Route route = new Route(1,"d");
        assertNotEquals (route.getId(),client.addRoute(route));

    }

}