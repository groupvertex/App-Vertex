package com.vertex.tracker.messaging;


import com.vertex.tracker.messaging.workers.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import java.util.Scanner;

@SpringBootApplication
@EnableJms
public class SenderApp {

    @Autowired
    JmsTemplate jmsTemplate;


    @Autowired
    Producer producer;


    public static void main(String[] args) throws JMSException {
        ConfigurableApplicationContext ctx = SpringApplication.run(SenderApp.class, args);

        SenderApp app = ctx.getBean(SenderApp.class);

        Scanner in = new Scanner(System.in);
        while (true) {
            String text = in.next();
            System.out.println("<<<" + text);
            app.producer.send(text, app.jmsTemplate, "VERTX.T");
        }

    }


}
