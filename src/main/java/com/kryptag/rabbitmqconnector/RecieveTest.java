/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kryptag.rabbitmqconnector;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author florenthaxha
 */
public class RecieveTest {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        RMQConnection rmqPub = new RMQConnection("student", "cph", "datdb.cphbusiness.dk", 5672, "hello");
        RMQConnection rmqCon = new RMQConnection("student", "cph", "datdb.cphbusiness.dk", 5672, "hello");
        ConcurrentLinkedQueue q = new ConcurrentLinkedQueue();
        RMQProducer rmqp = new RMQProducer(q, rmqPub);
        RMQConsumer rmqc = new RMQConsumer(q, rmqCon);
        //rmq.getMessageStream();
        //rmq.putMessageInQueue(q);
        rmqp.start();
        rmqc.start();
    }

}
