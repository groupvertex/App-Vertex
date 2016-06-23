package org;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.vertex.config.DBConfig;

import static org.testng.Assert.assertEquals;

/**
 * Created by user on 22.06.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DBConfig.class, RouteControllerTest.Conf.class})
@ActiveProfiles("test")

public class RouteControllerTest {

    @Autowired
    RouteController gc;

    @Configuration
    public static class Conf {
        @Bean
        RouteController routeController() {
            return new RouteController();
        }

    }


    @Test
    public void testRoute() throws Exception {
        String expected = "first";
        assertEquals(expected, gc.route(1).getName());

    }
}