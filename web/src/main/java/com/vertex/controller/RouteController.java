package com.vertex.controller;

import com.vertex.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public long addRoute(@RequestBody Route route) {
        return routeService.create(route);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Route getRoute(@PathVariable long id) {
        return routeService.read(id);
    }
}
