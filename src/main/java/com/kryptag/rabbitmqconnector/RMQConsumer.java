/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kryptag.rabbitmqconnector;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author florenthaxha
 */
public class RMQConsumer extends Thread {

    private final ConcurrentLinkedQueue queue;
    private final RMQConnection rmq;
    public RMQConsumer(ConcurrentLinkedQueue q, RMQConnection rmq) {
        this.queue = q;
        this.rmq = rmq;
        rmq.createConnection();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                doWork();
            } catch (Exception e) {
            }
        }
    }

    public Queue getQ() {
        return queue;
    }

    private void doWork() {
        if (!queue.isEmpty()) {
            System.out.println(queue.remove().toString());
        }
    }
    
    private void sendMessage(){
        
    }
}
