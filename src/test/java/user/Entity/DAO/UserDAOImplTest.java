package user.Entity.DAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import user.Entity.User;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22.05.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=UserDAOImplConf.class)
public class UserDAOImplTest {
    @Autowired
    private UserDAO my;

    @Configuration
    public static class Conf {
        @Bean
        DataSource dataSource() {
            return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.HSQL)
                    .addScript("classpath:create.sql")
                    .addScript("classpath:insert.sql")
                    .build();
        }

        @Bean
        NamedParameterJdbcTemplate j() {
            return new NamedParameterJdbcTemplate(dataSource());
        }
    }

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
}