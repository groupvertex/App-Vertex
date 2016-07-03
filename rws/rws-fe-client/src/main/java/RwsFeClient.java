import entity.Route;
import org.springframework.web.client.RestTemplate;

public class RwsFeClient {

    private String url = "http://localhost:8002/routes/";

    public long addRoute(Route route) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, route, Long.class);

    }
}
