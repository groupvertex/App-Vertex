package ua.vertex.route.Configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by Дмитрий on 17.05.2016.
 */


@Import(ua.vertex.waypoint.Configuration.Conf.class)
@Configuration
@ComponentScan("ua.vertex.route")
public class Conf {

    private static final String URL = "jdbc:postgresql://localhost:5436/tracker";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    @Bean
    DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL,USERNAME,PASSWORD);
        dataSource.setDriverClassName(org.postgresql.Driver.class.getName());
        return dataSource;
    }

    @Bean
    @Qualifier("route")
    JdbcTemplate jdbc(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
