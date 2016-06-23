package org;

import entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.vertex.dao.route.RouteDAO;

@Component
@RestController
public class RouteController {


    @Autowired
    private RouteDAO routeDAO;


    @RequestMapping("/route_read")
    public Route route(@RequestParam(value="id", required=true) long id) {
        return routeDAO.read(id);
    }
}