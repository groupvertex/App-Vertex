package my;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Route;
import entity.WayPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
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
        ResponseEntity<String> response = template.getForEntity(baseURL + "/1", String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response.getBody());
        JsonNode messageJson = responseJson.path("name");
        assertThat(messageJson.asText(), equalTo("first"));


    }

    @Test
    public void testAddRoute() throws Exception {
        RestTemplate rest = new TestRestTemplate();
        Route route = new Route();
        route.setId(4);
        route.setName("name4");
        List<WayPoint> waypoints = new ArrayList<>();

        WayPoint.Builder builder = WayPoint.newBuilder();
        builder.setId(10);
        builder.setRouteId(4);
        builder.setX(150);
        builder.setY(155);
        builder.setHeight(100);
        builder.setAccuracy(15);
        builder.setAddTime(Timestamp.valueOf("2016-06-07 12:12:12"));
        waypoints.add(builder.build());
        route.setWayPoints(waypoints);


        rest.postForObject(baseURL, route,Route.class);


        RestTemplate template = new TestRestTemplate();
        ResponseEntity<String> response2 = template.getForEntity(baseURL + "/4", String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response2.getBody());
        JsonNode messageJson = responseJson.path("name");
        assertThat(messageJson.asText(), equalTo("name4"));


    }

    @Test
    public void testUpdateRoute() throws Exception {
        RestTemplate rest1 = new TestRestTemplate();
        Route new_route = new Route();
        new_route.setId(5);
        new_route.setName("name5");
        List<WayPoint> new_waypoints = new ArrayList<>();

        WayPoint.Builder buildernew = WayPoint.newBuilder();
        buildernew.setId(10);
        buildernew.setRouteId(4);
        buildernew.setX(150);
        buildernew.setY(155);
        buildernew.setHeight(100);
        buildernew.setAccuracy(15);
        buildernew.setAddTime(Timestamp.valueOf("2016-06-07 12:12:12"));
        new_waypoints.add(buildernew.build());
        new_route.setWayPoints(new_waypoints);

        rest1.postForObject(baseURL, new_route,Route.class);


        RestTemplate rest = new RestTemplate();
        Route route = new Route();
        route.setName("name6");
        List<WayPoint> waypoints = new ArrayList<>();
        WayPoint.Builder builder = WayPoint.newBuilder();
        builder.setId(10);
        builder.setRouteId(4);
        builder.setX(150);
        builder.setY(155);
        builder.setHeight(100);
        builder.setAccuracy(15);
        builder.setAddTime(Timestamp.valueOf("2016-06-07 12:12:12"));
        waypoints.add(builder.build());
        route.setWayPoints(waypoints);

        rest.put(baseURL+"/5", route);

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response2 = template.getForEntity(baseURL + "/5", String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response2.getBody());
        JsonNode messageJson = responseJson.path("name");
        assertThat(messageJson.asText(), equalTo("name6"));

    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void testDeleteRoute() throws Exception {
        RestTemplate rest1 = new TestRestTemplate();
        Route route = new Route();
        route.setId(6);
        route.setName("name7");
        List<WayPoint> new_waypoints = new ArrayList<>();

        WayPoint.Builder buildernew = WayPoint.newBuilder();
        buildernew.setId(10);
        buildernew.setRouteId(4);
        buildernew.setX(150);
        buildernew.setY(155);
        buildernew.setHeight(100);
        buildernew.setAccuracy(15);
        buildernew.setAddTime(Timestamp.valueOf("2016-06-07 12:12:12"));
        new_waypoints.add(buildernew.build());
        route.setWayPoints(new_waypoints);

        rest1.postForObject(baseURL, route,Route.class);

        rest1.delete(baseURL+"/6");

         ResponseEntity<String> response2 = rest1.getForEntity(baseURL + "/6", String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response2.getBody());
        JsonNode messageJson = responseJson.path("name");
        assertThat(messageJson.asText(), equalTo("name7"));


    }
}