import entity.Route;
import my.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.vertex.dao.route.RouteDAO;
import ua.vertex.dao.route.RouteDAOImpl;
import ua.vertex.dao.waypoint.WayPointDAO;
import ua.vertex.dao.waypoint.WayPointDAOImpl;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class, RwsFeClientTest.Conf.class})
public class RwsFeClientTest {

    public static class Conf{

        @Autowired
        DataSource dataSource;

        @Bean
        RouteDAO routeDao(DataSource dataSource){
            return  new RouteDAOImpl(dataSource);
        }

        @Bean
        WayPointDAO wayPointDao(DataSource dataSource){
            return new WayPointDAOImpl(dataSource);
        }

        @Bean
        HttpMessageConverter httpMessageConverter(){
            return new MappingJackson2HttpMessageConverter();
        }
    }

    @Test
    public void addRoute() throws Exception {
        RwsFeClient client = new RwsFeClient();
        client.addRoute(new Route());
    }

}