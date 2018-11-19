/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kryptag.rabbitmqconnector.MessageClasses;

/**
 *
 * @author florenthaxha
 */
public class AggregatorMessage {
    private final String ssn;
    private final int numberOfBanks;

    public AggregatorMessage(String ssn, int numberOfBanks) {
        this.ssn = ssn;
        this.numberOfBanks = numberOfBanks;
    }

    public String getSsn() {
        return ssn;
    }

    public int getNumberOfBanks() {
        return numberOfBanks;
    }

    @Override
    public String toString() {
        return "AggregatorMessage{" + "ssn=" + ssn + ", numberOfBanks=" + numberOfBanks + '}';
    }
    
}
