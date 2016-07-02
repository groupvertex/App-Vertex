package ua.vertex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.vertex.dao.route.RouteDAO;

//@Component
@RestController
@RequestMapping("/route")
public class RouteController {
    private final String baseURL = "http://localhost:8081/route";

    @Autowired
    private RouteDAO routeDAO;

    @RequestMapping( method = RequestMethod.POST)
    public void addRoute(@RequestBody Route route) {
        routeDAO.create(route);
    }



}