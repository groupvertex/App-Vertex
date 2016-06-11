package com.vertex.tracker.messaging;


import com.vertex.tracker.messaging.workers.Consumer;
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

        String msg = null;
        while (!"exit".equals(msg)) {
            System.out.println(">>>: " + (msg = app.consumer.receive(app.jmsTemplate, "VERTX.T")));
        }

    }


}
