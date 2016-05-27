package com.vertex.controller;

import com.vertex.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.vertex.route.Entity.Route;

/**
 * Created by RASTA on 25.05.2016.
 */
@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Long> createRoute(@RequestBody Route route) {
        long routeId = routeService.create(route);
        HttpStatus status = routeId != -1 ? HttpStatus.OK : HttpStatus.CONFLICT;
        return new ResponseEntity<>(routeId, status);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Route> getRoute(@PathVariable long id) {
        Route route = routeService.read(id);
        HttpStatus status = route.getId() != -1 ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(routeService.read(id), status);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateRoute(@PathVariable long id, @RequestBody Route route) {
        routeService.update(id, route);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRoute(@PathVariable long id) {
        routeService.delete(id);
    }
}
