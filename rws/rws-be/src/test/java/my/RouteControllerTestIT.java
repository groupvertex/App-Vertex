package my;

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

/**
 * Created by user on 25.06.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, DBConfig.class})
@ActiveProfiles("test")
@WebAppConfiguration
@IntegrationTest({"server.port=8081"})

public class RouteControllerTestIT {


    private final String baseURL = "http://localhost:8081/route";


    @Test
    public void testGetRoute() throws Exception {
        RestTemplate template = new TestRestTemplate();
//        ResponseEntity<String> response = template.getForEntity(baseURL + "/1", String.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode responseJson = objectMapper.readTree(response.getBody());
//        JsonNode messageJson = responseJson.path("name");
//        assertThat(messageJson.asText(), equalTo("first"));

        Route route = template.getForObject(baseURL+"/1", Route.class);
        assertThat(route.getName(), equalTo("first"));


    }

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

    @Test
    public void testUpdateRoute() throws Exception {
        RestTemplate rest1 = new TestRestTemplate();
        Route new_route = new Route();
        new_route.setId(5);
        new_route.setName("name5");
        List<WayPoint> new_waypoints = new ArrayList<>();

        WayPoint wayPoint1 = WayPoint.newBuilder()
                .setId(10)
                .setRouteId(4)
                .setX(150)
                .setY(155)
                .setHeight(100)
                .setAccuracy(15)
                .setAddTime(Timestamp.valueOf("2016-06-07 12:12:12"))
                .build();

        new_waypoints.add(wayPoint1);
        new_route.setWayPoints(new_waypoints);

        rest1.postForObject(baseURL, new_route,Route.class);


        RestTemplate rest = new RestTemplate();
        Route route = new Route();
        route.setName("name6");
        List<WayPoint> waypoints = new ArrayList<>();
        WayPoint wayPoint2 = WayPoint.newBuilder()
                .setId(10)
                .setRouteId(4)
                .setX(150)
                .setY(155)
                .setHeight(100)
                .setAccuracy(15)
                .setAddTime(Timestamp.valueOf("2016-06-07 12:12:12"))
                .build();
        waypoints.add(wayPoint2);
        route.setWayPoints(waypoints);

        rest.put(baseURL+"/5", route);

        RestTemplate template = new RestTemplate();
        Route route2 = template.getForObject(baseURL+"/5", Route.class);
        assertThat(route2.getName(), equalTo("name6"));

    }

    @Test
    public void testDeleteRoute() throws Exception {
        RestTemplate rest1 = new TestRestTemplate();
        Route route = new Route();
        route.setId(6);
        route.setName("name7");
        List<WayPoint> new_waypoints = new ArrayList<>();

        WayPoint wayPoint = WayPoint.newBuilder()
                .setId(10)
                .setRouteId(4)
                .setX(150)
                .setY(155)
                .setHeight(100)
                .setAccuracy(15)
                .setAddTime(Timestamp.valueOf("2016-06-07 12:12:12"))
                .build();
        new_waypoints.add(wayPoint);
        route.setWayPoints(new_waypoints);

        rest1.postForObject(baseURL, route,Route.class);

        rest1.delete(baseURL+"/6");

        Route route2 = rest1.getForObject(baseURL+"/6", Route.class);
        assertThat(route2.getName(), equalTo(null));


    }
}