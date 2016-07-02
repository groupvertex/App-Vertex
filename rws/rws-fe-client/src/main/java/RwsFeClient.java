import entity.Route;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class RwsFeClient {

    private String url = "http://localhost:";

    public void addRoute(Route route) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url, route, Object.class, Collections.emptyMap());

    }
}
