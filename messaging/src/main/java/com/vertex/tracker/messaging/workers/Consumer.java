package com.vertex.tracker.messaging.workers;


import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public class Consumer {

    public String receive(JmsTemplate jms, String dest) throws JMSException {
        TextMessage msg = (TextMessage) jms.receive(new ActiveMQTopic(dest));
        return msg == null ? "" : msg.getText();
    }
}
