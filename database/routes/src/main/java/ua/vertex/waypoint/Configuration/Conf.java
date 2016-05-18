package ua.vertex.waypoint.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by Vasyl on 18/05/2016.
 */
@Configuration
@ComponentScan("ua.vertex.waypoint.Configuration")
public class Conf {

    private static final String URL = "jdbc:postgresql://localhost:5436/tracker";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    @Bean(name = "dataSource")
    DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL,USERNAME,PASSWORD);
        dataSource.setDriverClassName(org.postgresql.Driver.class.getName());
        return dataSource;
    }

    @Bean(name = "myRepo")
    JdbcTemplate myRepo(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}