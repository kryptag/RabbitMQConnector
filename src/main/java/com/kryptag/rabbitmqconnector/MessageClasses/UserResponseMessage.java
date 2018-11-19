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
public class UserResponseMessage extends CreditMessage{
    private final float interestRate;

    public UserResponseMessage(float interestRate, int creditScore, String ssn, double loanAmount, int loanDuration) {
        super(creditScore, ssn, loanAmount, loanDuration);
        this.interestRate = interestRate;
    }

    public float getInterestRate() {
        return interestRate;
    }
    
}
