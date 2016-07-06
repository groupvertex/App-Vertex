package ua.vertex.controller;

import entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.vertex.exception.RouteNotFoundException;
import ua.vertex.service.RouteService;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Route getRoute(@PathVariable long id) {
        return routeService.read(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public long addRoute(@RequestBody Route route) {
        return routeService.create(route);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateRoute(@PathVariable long id, @RequestBody Route route) {
        routeService.update(route, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRoute(@PathVariable long id) {
        routeService.delete(id);
    }

    @ExceptionHandler(RouteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String RouteNotFoundHandler(RouteNotFoundException e) {
        return e.getMessage();
    }
}