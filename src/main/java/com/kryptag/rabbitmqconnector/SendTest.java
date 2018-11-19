/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kryptag.rabbitmqconnector;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author florenthaxha
 */
public class SendTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, TimeoutException {
        RMQConnection rmq = new RMQConnection("student", "cph", "datdb.cphbusiness.dk", 5672, "hello");
        rmq.createConnection();
        String message = new BasicMessage("1241512", 291581.0, 30).toString();
        rmq.sendMessage(message);
        
        
    }

}
