/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kryptag.rabbitmqconnector;

import java.io.IOException;

/**
 *
 * @author florenthaxha
 */
public class RecieveTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        RMQConnection rmq = new RMQConnection("student", "cph", "datdb.cphbusiness.dk", 5672, "hello");
        rmq.createConnection();
        
        rmq.getMessageStream();
    }
    
}
