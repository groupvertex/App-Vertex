package com.vertex.tracker.messaging.configuration;

import com.vertex.tracker.messaging.workers.Consumer;
import com.vertex.tracker.messaging.workers.Producer;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MessagingConfiguration {
    @Bean
    ActiveMQConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
    }

    @Bean
    ActiveMQTopic messageDestination() {
        ActiveMQTopic topic = new ActiveMQTopic("VERTX.T");
        return topic;
    }

    @Bean
    JmsListenerContainerFactory containerFactory(){
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        return containerFactory;
    }

    @Bean
    JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setReceiveTimeout(10000);
        jmsTemplate.setDefaultDestination(messageDestination());
        return jmsTemplate;
    }

    @Bean
    Producer producer() {
        return new Producer();
    }

    @Bean
    Consumer consumer() {
        return new Consumer();
    }
}
