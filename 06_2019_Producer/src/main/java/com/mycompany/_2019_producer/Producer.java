/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._2019_producer;

import java.util.Properties;
import java.util.Random;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author signorautoma
 */
public class Producer {

    Properties properties = null;
    Context jndiContex = null;
    ConnectionFactory connectionFactory = null;
    Connection connection = null;
    Session session = null;
    Destination destination = null;
    String destinationName = "dynamicTopics/professors";
    private MessageProducer producer = null;
    
    private String id;
    private float Rank;
    private Random professorId = new Random();

    public float getRank() {
        return professorId.nextFloat() * 100;
    }

    public String getId() {
        return Integer.toString(professorId.nextInt(6 + 1));
    }

    Properties props = new Properties();

    public  void start() throws NamingException, JMSException {

        try {
            properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            properties.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            jndiContex = new InitialContext(properties);
        } catch (NamingException e) {
            System.out.println(e.toString());
            System.exit(1);
        }
        
        connectionFactory = (ConnectionFactory)jndiContex.lookup("ConnectionFactory");
        destination = (Destination)jndiContex.lookup(destinationName);
        
        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        producer = session.createProducer(destination);
        
        String id;
        Float rank;
        String text;
        TextMessage message = session.createTextMessage();
        
        while (true) {            
            id = getId();
            rank = getRank();
            
            message.setStringProperty("id", id);
            message.setFloatProperty("rank", rank);
            
            text = "Professor: "+ id + ": " + Float.toString(rank);
            message.setText(text);
            
            this.producer.send(message);
            System.err.println(text);
            
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
        
    }

}
