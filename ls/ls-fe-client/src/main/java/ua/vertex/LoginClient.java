package ua.vertex;

import entity.AuthenticationRequest;
import entity.HeaderRequestInterceptor;
import entity.User;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class LoginClient {
    private static final String LOGIN_FE = "http://localhost:8003/login";
    private static final String AUTH_URL = LOGIN_FE + "/auth";
    private static final String SIGN_UP_URL = LOGIN_FE + "/signup";
    private static final String VALID_TOKEN_URL = "http://localhost:8003/check";

    private static final RestTemplate restTemplate = new RestTemplate();

    public String login(String login, String password) {
        AuthenticationRequest request = new AuthenticationRequest(login, password);
        return restTemplate.postForObject(AUTH_URL, request, String.class);
    }

    public long signUp(User user) {

        return restTemplate.postForObject(SIGN_UP_URL, user, Long.class);
    }

    public boolean isValidSession(String token) {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Authorization", token));
        restTemplate.setInterceptors(interceptors);
        restTemplate.getForObject(VALID_TOKEN_URL, Void.class);
        return true;
    }

}
