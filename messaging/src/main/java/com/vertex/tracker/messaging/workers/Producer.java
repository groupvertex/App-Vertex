package com.vertex.tracker.messaging.workers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;

@Service
public class Producer {

    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);

    @Autowired
    JmsTemplate jms;

    public void send(String text, Destination destination) throws JMSException {
        LOG.info("Sending : {}", text);
        jms.send(destination, s -> s.createTextMessage(text));
    }
}
