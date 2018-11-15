/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kryptag.rabbitmqconnector;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author florenthaxha
 */
public class RMQConnection {

    private String username;
    private String password;
    private String hostName;
    private int portNumber;
    private String queuename;
    private Connection connection = null;

    public RMQConnection(String username, String password, String hostName, int portNumber, String queuename) {
        this.username = username;
        this.password = password;
        this.hostName = hostName;
        this.portNumber = portNumber;
        this.queuename = queuename;

    }

    public void createConnection() {
        if (this.connection == null) {
            this.connection = createConnectionHelper();
        } else {
            try {
                this.connection.close();
                this.connection = createConnectionHelper();
            } catch (IOException e) {
            }
        }
    }
    
    public void putMessageInQueue(ConcurrentLinkedQueue q) throws IOException, InterruptedException {
        Channel chan = this.connection.createChannel();
        chan.queueDeclare(queuename, false, false, false, null);
        QueueingConsumer consumer = new QueueingConsumer(chan);
	chan.basicConsume(queuename, true, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
	    String message = new String(delivery.getBody());
            q.add(message);
        }
    }
    
    public void getMessageStream() throws IOException, InterruptedException {
        Channel chan = this.connection.createChannel();
        chan.queueDeclare(queuename, false, false, false, null);
        QueueingConsumer consumer = new QueueingConsumer(chan);
	chan.basicConsume(queuename, true, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
	    String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
        }
    }

    public void sendMessage(String msg) {
        Channel chan = null;
        try {
            chan = this.connection.createChannel();
            chan.basicPublish("", queuename, null, msg.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(RMQConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (chan != null) {
                    chan.close();
                    this.connection.close();
                    this.connection = null;
                }
            } catch (IOException | TimeoutException ex) {
                Logger.getLogger(RMQConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Connection createConnectionHelper() {
        Connection temp = null;
        try {
            ConnectionFactory fac = new ConnectionFactory();
            fac.setUsername(username);
            fac.setPassword(password);
            fac.setHost(hostName);
            fac.setPort(portNumber);
            temp = fac.newConnection();
            return temp;
        } catch (IOException | TimeoutException e) {
        }
        return temp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public String getQueuename() {
        return queuename;
    }

    public void setQueuename(String queuename) {
        this.queuename = queuename;
    }

    public Connection getConnection() {
        return connection;
    }

}
