package ua.vertex.alert;

import entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Repository;
import ua.vertex.config.DBConfig;
import ua.vertex.config.XmlSpringAnalytics;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Repository
@Import(XmlSpringAnalytics.class)
public class AlertServiceImpl implements AlertService {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendRouteAllert(Route route) {
        jmsTemplate.send("fromRwsToAnalytic.alert.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(route);
            }
        });
    }
}
