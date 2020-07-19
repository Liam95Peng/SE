/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.giugno2019_client_01;

import com.mycompany.giugno2019_server_01.Professor;
import com.mycompany.giugno2019_server_01.Service;
import com.mycompany.giugno2019_server_01.ServiceImplService;
import java.util.Properties;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author signorautoma
 */
public class ClientListener implements MessageListener {

    private TopicConnection connection;

    public ClientListener() {
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            Context ctx = new InitialContext(props);

            ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
            connection = (TopicConnection) connectionFactory.createConnection();
            TopicSession session = (TopicSession) connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = (Destination) ctx.lookup("dynamicTopics/professors");
            TopicSubscriber subscriber = session.createSubscriber((Topic) destination);
            subscriber.setMessageListener(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void start() {
        try {
            connection.start();
        } catch (Exception e) {
        }
    }

    void stop() {
        try {
            connection.stop();
        } catch (Exception e) {
        }
    }

    @Override
    public void onMessage(Message msg) {
        try {

            String id = msg.getStringProperty("id");
            float rank = msg.getFloatProperty("rank");
            System.err.println("New message: " + id + " " + rank);

            ServiceImplService service = new ServiceImplService();
            Service port = service.getServiceImplPort();

            Professor res = port.getDetails(id);

            //System.out.println("Professor " + id + ": " + res);
            if (res != null) {
                System.out.println("Professor " + id + " is " + res.getName() + " " + res.getSurname() + " and has rank " + rank);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
