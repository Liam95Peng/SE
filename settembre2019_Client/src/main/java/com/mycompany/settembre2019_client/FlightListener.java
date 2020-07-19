/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.settembre2019_client;

import java.sql.*;
import java.sql.Connection;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author biar
 */
public class FlightListener implements MessageListener {
    private Connection connection;
    private TopicConnection jmsConnection;
    private final static Pattern statusPattern = Pattern.compile(".* : (.*)");


    public FlightListener() {
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            Context ctx = new InitialContext(props);

            ConnectionFactory connectionFactory = (ConnectionFactory)ctx.lookup("ConnectionFactory");
            jmsConnection = (TopicConnection)connectionFactory.createConnection();
            TopicSession session = (TopicSession) jmsConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = (Destination)ctx.lookup("dynamicTopics/Flights");
            TopicSubscriber subscriber = session.createSubscriber((Topic)destination);
            subscriber.setMessageListener(this);

            Class.forName("org.sqlite.JDBC");
        } catch (JMSException | NamingException | ClassNotFoundException err) {
            err.printStackTrace();
            System.exit(1);
        }
    }


    public void onMessage(Message msg) {
        try {
            String flight = msg.getStringProperty("flight");
            String text = ((TextMessage)msg).getText();

            Matcher matcher = statusPattern.matcher(text);
            if (matcher.find()) {
                String status = matcher.group(1);

                PreparedStatement statement = connection.prepareStatement("INSERT INTO flights VALUES(?, ?)");
                statement.setQueryTimeout(30);

                statement.setString(1, flight);
                statement.setString(2, status);
                statement.executeUpdate();

                System.out.println(String.format("%s -> %s", flight, status));
            }
        } catch (JMSException | SQLException err) {
            err.printStackTrace();
        }
    }


    public void start() {
        try {
            jmsConnection.start();
            connection = DriverManager.getConnection("jdbc:sqlite:/home/studente/settembre2019_database.db");
        } catch (JMSException | SQLException err) {
            err.printStackTrace();
        }
    }


    public void stop() {
        try {
            jmsConnection.stop();
            if (connection != null) {
                connection.close();
            }
        } catch (JMSException | SQLException err) {
            err.printStackTrace();
        }
    }
    /*private TopicConnection topicConnection; // topic based on the connection
    private TopicSession topicSession = null; // session 
    private Destination destination = null;
    private MessageProducer producer = null;
    
     private final static Pattern statusPattern = Pattern.compile(".* : (.*)");
    
    public FlightListner(){
        
        Context jndiContext = null;
        ConnectionFactory topicConnectionFactory = null;

        String destinationName = "dynamicTopics/Flights"; // destination name
        
        try {

            Properties props = new Properties();

            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616"); // URL OF THE PUBLISHER
            jndiContext = new InitialContext(props);

            topicConnectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
            destination = (Destination) jndiContext.lookup(destinationName);
            topicConnection = (TopicConnection) topicConnectionFactory.createConnection();
            
            
            topicSession = (TopicSession) topicConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            
            TopicSubscriber topicSubscriber
                    = topicSession.createSubscriber((Topic) destination);
            

            topicSubscriber.setMessageListener(this);
        } catch (JMSException err) {
            err.printStackTrace();
        } catch (NamingException err) {
            err.printStackTrace();
        }
    }
    
    /**
     * Stop the listner
     * @author Giulio Serra 1904089
     */
    /*public void stop() {
        try {
            topicConnection.stop();
        } catch (JMSException err) {
            err.printStackTrace();
        }
    }

    /**
     * Start the listner
     * @author Giulio Serra 1904089
     */
    /*public void start() {
        try {
            topicConnection.start();
        } catch (JMSException err) {
            err.printStackTrace();
        }
    }*/

    /**
     * Event handler to react on messages arrival
     * @author Giulio Serra 1904089
     */
    /*public void onMessage(Message mex) {
        try {
         
           String flight = mex.getStringProperty("flight");
           String text = ((TextMessage)mex).getText();
          

            Matcher matcher = statusPattern.matcher(text);
            if (matcher.find()) {
                String status = matcher.group(1);
                
                System.out.println("Arrived flight: " + flight + " has landed: " + status);
                DatabaseManager.addFlight(flight, status);
                
            }*/
           
     
           
           /*System.out.println("Database content:");
           DatabaseManager.printContent();*/
         

        /*} catch (JMSException err) {
            err.printStackTrace();
        }
        
        
    }*/
}
