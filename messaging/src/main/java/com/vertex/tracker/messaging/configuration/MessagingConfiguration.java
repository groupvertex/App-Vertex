package com.vertex.tracker.messaging.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfiguration {
    @Bean
    ActiveMQConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
    }
}
