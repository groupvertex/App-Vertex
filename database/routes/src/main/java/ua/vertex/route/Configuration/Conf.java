package ua.vertex.route.Configuration;

import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by Дмитрий on 19.05.2016.
 */

@Import(ua.vertex.waypoint.Configuration.Conf.class)
@Configuration
@ComponentScan("ua.vertex.route")
@PropertySource("classpath:db.properties")
public class Conf {

    @Value("${url}")
    private String URL;
    @Value("${username}")
    private String USERNAME;
    @Value("${password}")
    private String PASSWORD;

    @Bean
    @Qualifier("route")
    DataSource dataSource(){
        PGPoolingDataSource dataSource = new PGPoolingDataSource();
        dataSource.setUrl(URL);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setInitialConnections(5);
        dataSource.setMaxConnections(15);
        return dataSource;

    }

    @Bean
    public static PropertyPlaceholderConfigurer properties(){
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ClassPathResource[] resources = new ClassPathResource[ ]
                { new ClassPathResource( "db.properties" ) };
        ppc.setLocations( resources );
        ppc.setIgnoreUnresolvablePlaceholders( true );
        return ppc;
    }

    @Bean
    NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
