/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kryptag.rabbitmqconnector;

import java.util.Date;

/**
 *
 * @author florenthaxha
 */
public class BasicMessage {
    
    private final String ssn;
    private final int creditScore;
    private final double loanAmount;
    private final Date loanDuration;

    public BasicMessage(String ssn, int creditScore, double loanAmount, Date loanDuration) {
        this.ssn = ssn;
        this.creditScore = creditScore;
        this.loanAmount = loanAmount;
        this.loanDuration = loanDuration;
    }

    public String getSsn() {
        return ssn;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Date getLoanDuration() {
        return loanDuration;
    }

    @Override
    public String toString() {
        return "BasicMessage{" + "ssn=" + ssn +
                            ", creditScore=" + creditScore + 
                            ", loanAmount=" + loanAmount + 
                            ", loanDuration=" + loanDuration + '}';
    }
    
    
}
