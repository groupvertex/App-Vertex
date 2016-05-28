package user.Entity.DAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import user.Entity.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by user on 22.05.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UserDAOImplConf.class)
@ActiveProfiles("test")
public class UserDAOImplTest {
    @Autowired
    private UserDAO my;


    @Test
    public void testRead() throws Exception {
        User expected = new User();
        expected.setId(1);
        expected.setFirstName("name");
        expected.setLastName("lastname");
        expected.setEmail("myemail");
        expected.setPassword("password");
        assertEquals(expected, my.read(1));


    }

    @Test
    public void create() throws Exception {
        User user = new User();
        user.setId(2);
        user.setFirstName("name2");
        user.setLastName("lastname2");
        user.setEmail("myemail2");
        user.setPassword("password2");
        my.create(user);
        assertEquals("name2", my.read(2).getFirstName());
    }

    @Test
    public void update() throws Exception {
        User user1 = new User();
        user1.setId(3);
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
        my.update(user2, 3);
        assertEquals("name3", my.read(3).getFirstName());
    }

    @Test
    public void delete() throws Exception {
        User user = new User();
        user.setId(4);
        user.setFirstName("name4");
        user.setLastName("lastname4");
        user.setEmail("email4");
        user.setPassword("password4");
        my.create(user);
        my.delete(4);
        User user2 = new User();
        user2.setEmail("newemail");
        user2.setId(4);
        my.create(user2);
        assertNull(my.read(4).getFirstName());
    }

}