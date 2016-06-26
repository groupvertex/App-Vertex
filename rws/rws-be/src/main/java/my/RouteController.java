package my;

import entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.vertex.dao.route.RouteDAO;

//@Component
@RestController
@RequestMapping("/route")
public class RouteController {


    @Autowired
    private RouteDAO routeDAO;


    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Route getRoute(@PathVariable long id) {
        return routeDAO.read(id);

    }

    @RequestMapping( method = RequestMethod.POST)
    public void addRoute(@RequestBody Route route) {
        routeDAO.create(route);

    }

    @RequestMapping( value="/{id}", method = RequestMethod.PUT)
    public void updateRoute(@PathVariable long id , @RequestBody Route route) {
        System.out.println("updating route");
        routeDAO.update(route, id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteRoute(@PathVariable long id) {
        routeDAO.delete(id);
    }



}