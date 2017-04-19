package all;

import config.DBConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfiguration.class)
@ActiveProfiles("test")
public class JdbcTemplateConfigManagerDAOTest {
    @Autowired
    private JdbcTemplateConfigManagerDAO config;

    @Test
    public void get() throws Exception {
        String value = config.get("StringKey");
        Assert.assertEquals("StringValue", value);
    }

}