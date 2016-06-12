package com.vertex.tracker.messaging;


import com.vertex.tracker.messaging.workers.Consumer;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;

@SpringBootApplication
@EnableJms
public class ReceiverApp {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Consumer consumer;

    public static void main(String[] args) throws JMSException {
        ConfigurableApplicationContext ctx = SpringApplication.run(ReceiverApp.class, args);

        ReceiverApp app = ctx.getBean(ReceiverApp.class);

        ActiveMQTopic dest = new ActiveMQTopic("VERTX.T");
        while (!"exit".equals(app.consumer.receive(dest))) {
        }
    }


}
