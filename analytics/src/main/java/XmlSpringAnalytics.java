import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import ua.vertex.config.DBConfig;

@Repository
@Import(DBConfig.class)
public class XmlSpringAnalytics {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
}