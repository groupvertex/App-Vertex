package ua.vertex;

        import entity.Route;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

//@Component
@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService service;

    @RequestMapping( value = "/", method = RequestMethod.POST)
    public long addRoute(@RequestBody Route route) {
        return service.create(route);
    }



}