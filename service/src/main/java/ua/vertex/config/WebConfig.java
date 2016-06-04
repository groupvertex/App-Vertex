package ua.vertex.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"ua.vertex.controller", "ua.vertex.service"})
@Import(DBConfig.class)
public class WebConfig {

}
