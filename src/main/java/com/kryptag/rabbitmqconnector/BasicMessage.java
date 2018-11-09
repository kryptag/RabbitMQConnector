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
    private final double loanAmount;
    private final Date loanDuration;

    public BasicMessage(String ssn, double loanAmount, Date loanDuration) {
        this.ssn = ssn;
        this.loanAmount = loanAmount;
        this.loanDuration = loanDuration;
    }

    public String getSsn() {
        return ssn;
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
                            ", loanAmount=" + loanAmount + 
                            ", loanDuration=" + loanDuration + '}';
    }
    
    
}
