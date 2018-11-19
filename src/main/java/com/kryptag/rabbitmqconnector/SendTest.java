/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kryptag.rabbitmqconnector;

import com.google.gson.Gson;
import com.kryptag.rabbitmqconnector.Enums.ExchangeNames;
import com.kryptag.rabbitmqconnector.MessageClasses.BasicMessage;
import java.io.IOException;
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
        RMQConnection rmq = new RMQConnection("guest", "guest", "datdb.cphbusiness.dk", 5672, ExchangeNames.ENTRY_POINT.toString());
        Gson g = new Gson();
        rmq.createConnection();
        BasicMessage message = new BasicMessage("1241512", 291581.0, 30);
        rmq.sendMessage(g.toJson(message));
        
        
    }

}
