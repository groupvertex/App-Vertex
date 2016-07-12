package ua.vertex;

import entity.Route;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class RwsFeClient {

    private String url = "http://localhost:8002/routes";
    private String tokenHeader = "Authorization";
    private RestTemplate restTemplate;

    public RwsFeClient(String authToken) {
        restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add((httpRequest, bytes, execution) -> {
            HttpRequest wrapper = new HttpRequestWrapper(httpRequest);
            wrapper.getHeaders().set(tokenHeader, authToken);
            return execution.execute(wrapper, bytes);
        });
        restTemplate.setInterceptors(interceptors);
    }

    public long addRoute(Route route) {
        return restTemplate.postForObject(url, route, Long.class);
    }
}