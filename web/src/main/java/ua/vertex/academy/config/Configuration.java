package ua.vertex.academy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ua.vertex.academy.aspect.ServiceAspect;


/**
 * Created by RASTA on 19.05.2016.
 */
@org.springframework.context.annotation.Configuration
@ComponentScan("ua.vertex")
@EnableAspectJAutoProxy
public class Configuration {


    @Bean
    ServiceAspect serviceAspect() {
        return new ServiceAspect();
    }
}
