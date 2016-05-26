package com.vertex.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import ua.vertex.Conf;


/**
 * Created by RASTA on 19.05.2016.
 */
@org.springframework.context.annotation.Configuration
@ComponentScan("com.vertex")
@Import(Conf.class)
public class Configuration {

}
