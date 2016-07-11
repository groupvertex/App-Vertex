package ua.vertex.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthChecker {

    @Value("${ls.check}")
    private String checkUrl;

    @Value("${jwt.header}")
    private String tokenHeader;

    private RestTemplate restTemplate = new RestTemplate();

    public boolean check(ServletRequest request) {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String authToken = servletRequest.getHeader(tokenHeader);
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

        interceptors.add((httpRequest, bytes, execution) -> {
            HttpRequest wrapper = new HttpRequestWrapper(httpRequest);
            wrapper.getHeaders().set(tokenHeader, authToken);
            return execution.execute(wrapper, bytes);
        });
        restTemplate.setInterceptors(interceptors);
        restTemplate.getForObject(checkUrl, Void.class);
        return true;
    }
}
