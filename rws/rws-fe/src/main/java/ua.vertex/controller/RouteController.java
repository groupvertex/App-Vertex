package ua.vertex.controller;

import entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import ua.vertex.security.AuthChecker;
import ua.vertex.service.RouteService;

import javax.servlet.ServletRequest;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService service;
    @Autowired

    private AuthChecker checker;


    @RequestMapping(method = RequestMethod.POST)
    public long addRoute(@RequestBody Route route, ServletRequest request) {
        checker.check(request);
        return service.create(route);
    }

    @ExceptionHandler({HttpServerErrorException.class, HttpClientErrorException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String unAuthorizedExHandler() {
        return "You aren't authorized in our system";
    }
}