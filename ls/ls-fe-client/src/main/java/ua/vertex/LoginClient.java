package ua.vertex;

import entity.AuthenticationRequest;
import entity.User;
import org.springframework.web.client.RestTemplate;

public class LoginClient {
    private static final String LOGIN_FE = "http://localhost:8081/login";
    private static final String AUTH_URL = LOGIN_FE + "/auth";
    private static final String SIGN_UP_URL = LOGIN_FE + "/signup";
    private static final String VALID_TOKEN_URL = LOGIN_FE + "/valid";

    private static final RestTemplate restTemplate = new RestTemplate();

    public String login(String login, String password) {
        AuthenticationRequest request = new AuthenticationRequest(login, password);
        return restTemplate.postForObject(AUTH_URL, request, String.class);
    }

    public long signUp(User user) {

        return restTemplate.postForObject(SIGN_UP_URL, user, Long.class);
    }

    public boolean isValidToken(String token) {
        return restTemplate.postForObject(VALID_TOKEN_URL, token, Boolean.class);
    }


}
