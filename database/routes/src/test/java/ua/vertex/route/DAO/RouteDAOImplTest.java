//package ua.vertex.route.DAO;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import ua.vertex.route.config.Conf;
//import ua.vertex.route.Entity.Route;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Conf.class)
//public class RouteDAOImplTest {
//
//
//    @Autowired
//    RouteDAO routeDAO;
//
//
//
//    @Test
//    public void read() throws Exception {
//
//        Route expected = new Route(1,"track_one");
//
//        Route route = routeDAO.read(1);
//
//        Assert.assertEquals(expected.getName(),route.getName());
//
//    }
//
//    @Test
//    public void update() throws Exception{
//
//        routeDAO.create(new Route(2,"forTestUpdate"));
//
//        routeDAO.update(new Route(3,"afterUpdateTest"),2);
//
//        Route expected = new Route(3,"afterUpdateTest");
//
//        Assert.assertEquals(expected.getName(),"afterUpdateTest");
//
//    }
//
//    @Test
//    public void create() throws Exception{
//
//        routeDAO.create(new Route(5,"forTestCreate"));
//
//        Assert.assertEquals("forTestCreate",routeDAO.read(5).getName());
//
//    }
//
//    @Test(expected = EmptyResultDataAccessException.class)
//    public void delete() throws Exception{
//
//        routeDAO.create(new Route(10,"fotTestDelete"));
//
//        routeDAO.delete(10);
//
//        routeDAO.read(10).getName();
//    }
//
//}