package com.vertex.tracker.messaging.workers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

@Service
public class Consumer {

    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private JmsTemplate jms;

    public String receive(Destination destination) throws JMSException {
        TextMessage msg = (TextMessage) jms.receive(destination);
        String result = msg == null ? "" : msg.getText();
        LOG.info("Got message : {}", result);
        return result;
    }


}
