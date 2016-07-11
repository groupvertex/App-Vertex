package ua.vertex.controller;

import entity.Route;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import ua.vertex.RwsBeApplication;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(RwsBeApplication.class)
@WebIntegrationTest("server.port:8001")
public class RouteControllerTestIT {

    private static RestTemplate restTemplate = new RestTemplate();
    private final String baseURL = "http://localhost:8001/routes/";
    private Route testRoute;

    @Before
    public void init() {
        testRoute = new Route("tested");
        long id = restTemplate.postForObject(baseURL, testRoute, Long.class);
        testRoute.setId(id);
    }

    @After
    public void clear() {
        restTemplate.delete(baseURL + testRoute.getId());
    }

    @Test
    public void testGetRoute() throws Exception {
        Route tested = restTemplate.getForObject(baseURL + testRoute.getId(), Route.class);
        assertEquals("tested", tested.getName());
    }


    @Test
    public void testUpdateRoute() throws Exception {
        testRoute.setName("name5");
        restTemplate.put(baseURL + testRoute.getId(), testRoute);
        Route fromServer = restTemplate.getForObject(baseURL + testRoute.getId(), Route.class);
        assertEquals(testRoute.getName(), fromServer.getName());
    }

    @Test()
    public void testDeleteRoute() throws Exception {
        restTemplate.delete(baseURL + testRoute.getId());
    }
}