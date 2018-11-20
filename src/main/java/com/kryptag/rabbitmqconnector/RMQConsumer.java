/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kryptag.rabbitmqconnector;

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
        this.rmq.createConnection();
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

    private void doWork() {
        if (!queue.isEmpty()) {
            System.out.println(queue.remove().toString());
        }
    }
        
    public ConcurrentLinkedQueue getQueue() {
        return queue;
    }

    public RMQConnection getRmq() {
        return rmq;
    }
}
