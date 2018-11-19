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
public class LoanResponse {
    private final float interestRate;
    private final String ssn;

    public LoanResponse(float interestRate, String ssn) {
        this.interestRate = interestRate;
        this.ssn = ssn;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public String getSsn() {
        return ssn;
    }
    
}
