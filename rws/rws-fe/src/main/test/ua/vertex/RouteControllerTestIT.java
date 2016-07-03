package ua.vertex;

import entity.Route;
import entity.WayPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import ua.vertex.config.DBConfig;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, DBConfig.class})
@ActiveProfiles("test")
@WebAppConfiguration
@IntegrationTest({"server.port=8081"})
public class RouteControllerTestIT {



    private final String baseURL = "http://localhost:8081/route";
    @Test
    public void testAddRoute() throws Exception {
        RestTemplate rest = new TestRestTemplate();
        Route route = new Route();
        route.setId(4);
        route.setName("name4");
        List<WayPoint> waypoints = new ArrayList<>();

        WayPoint wayPoint = WayPoint.newBuilder()
                .setId(10)
                .setRouteId(4)
                .setX(150)
                .setY(155)
                .setHeight(100)
                .setAccuracy(15)
                .setAddTime(Timestamp.valueOf("2016-06-07 12:12:12"))
                .build();

        waypoints.add(wayPoint);
        route.setWayPoints(waypoints);

        rest.postForObject(baseURL, route,Route.class);

        RestTemplate template = new TestRestTemplate();
        Route route2 = template.getForObject(baseURL+"/4", Route.class);
        assertThat(route2.getName(), equalTo("name4"));
    }

}