package ua.vertex.route.DAO;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.vertex.route.Configuration.Conf;
import ua.vertex.route.Entity.Route;

import static org.junit.Assert.*;

/**
 * Created by Дмитрий on 17.05.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Conf.class)
public class RouteDAOImplTest {

    @Autowired
    RouteDAO dao;

    @After
    public void clean(){
        dao.delete(2);
    }

    @org.junit.Test
    public void create() throws Exception {
        Route route = new Route(2,"testName");
        dao.create(route);
        Route expected = dao.read(2);
        assertEquals(route,expected);
    }

    @org.junit.Test
    public void update() throws Exception {
        Route route = new Route(2,"test");
        dao.create(route);
        route.setName("testAfterUpdate");
        dao.update(route,2);
        Route expected = dao.read(2);
        assertEquals(expected.getName(),"testAfterUpdate");
    }

}