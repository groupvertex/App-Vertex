package com.vertex.tracker.messaging.workers;


import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.TextMessage;

public class Producer {

    public void send(String text, JmsTemplate jms, String dest) throws JMSException {
        ActiveMQTopic destination = new ActiveMQTopic(dest);
        jms.send(destination, s -> {
            TextMessage msg = s.createTextMessage(text);
            msg.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
            return msg;


        });
    }
}
