package ua.vertex.dao;

import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.vertex.config.DBConfig;
import ua.vertex.dao.user.UserDAO;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 04.06.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfig.class)
@ActiveProfiles("test")
public class UserDAOImplTest {
    @Autowired
    private UserDAO my;


    @Test
    public void testRead() throws Exception {
        User expected = new User();
        expected.setId(1);
        expected.setFirstName("Vasyl");
        expected.setLastName("Malik");
        expected.setEmail("leo124@bigmir.net");
        expected.setPassword("123");
        assertEquals(expected, my.read(1));


    }

    @Test
    public void create() throws Exception {
        User user = new User();
        user.setId(3);
        user.setFirstName("name2");
        user.setLastName("lastname2");
        user.setEmail("myemail2");
        user.setPassword("password2");
        my.create(user);
        assertEquals("name2", my.read(3).getFirstName());
    }

    @Test
    public void update() throws Exception {
        User user1 = new User();
        user1.setId(4);
        user1.setFirstName("name1");
        user1.setLastName("lastname1");
        user1.setEmail("email1");
        user1.setPassword("password1");
        my.create(user1);
        User user2 = new User();
        user2.setFirstName("name3");
        user2.setLastName("lastname3");
        user2.setEmail("email3");
        user2.setPassword("password3");
        my.update(user2, 4);
        assertEquals("name3", my.read(4).getFirstName());
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void delete() throws Exception {
        User user = new User();
        user.setId(5);
        user.setFirstName("name4");
        user.setLastName("lastname4");
        user.setEmail("email4");
        user.setPassword("password4");
        my.create(user);
        my.delete(5);
        my.read(5).getFirstName();
    }

}
