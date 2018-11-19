/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kryptag.rabbitmqconnector;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author florenthaxha
 */
public class RMQProducer extends Thread {
    private final ConcurrentLinkedQueue queue;
    private final RMQConnection rmq;
    
    public RMQProducer(ConcurrentLinkedQueue queue, RMQConnection rmq) {
        this.queue = queue;
        this.rmq = rmq;
        this.rmq.createConnection();
    }
    
    @Override
    public void run(){
        
        try {
            rmq.putMessageInQueue(queue);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(RMQProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ConcurrentLinkedQueue getQueue() {
        return queue;
    }

    public RMQConnection getRmq() {
        return rmq;
    }
    
    
}
