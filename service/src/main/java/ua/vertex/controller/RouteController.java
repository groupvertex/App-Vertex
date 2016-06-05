package ua.vertex.controller;

import ua.vertex.exception.RouteNotFoundException;
import ua.vertex.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import entity.Route;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public long createRoute(@RequestBody Route route) {
        long routeId = routeService.create(route);
        return routeId;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.FOUND)
    public Route getRoute(@PathVariable long id) {
        Route route = routeService.read(id);
        return route;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateRoute(@PathVariable long id, @RequestBody Route route) {
        routeService.update(id, route);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRoute(@PathVariable long id) {
        routeService.delete(id);
    }

    @ExceptionHandler(RouteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void routeNotFound() {

    }
}
