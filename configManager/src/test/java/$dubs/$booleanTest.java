package $dubs;

import all.PropertiesDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;

/**
 * Created by vertex0008 on 02.07.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = $booleanTest.Conf.class)
public class $booleanTest {

    public static class Conf {
        @Bean
        PropertiesDAO propertiesDAO() {
            PropertiesDAO mock = Mockito.mock(PropertiesDAO.class);
            return mock;

        }
    }

    @Autowired
    PropertiesDAO propertiesDao;

    @Before
    public void setUp() {
        Mockito.reset(propertiesDao);
    }

    @Test
    public void shouldCorrectlyProcessBooleanValue() throws Exception {
        $boolean b = new $boolean("myProperty", false);
        Mockito.when(propertiesDao.get(eq("myProperty"))).thenReturn("true");
        assertEquals("true", b.get());

    }
}