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
public class RuleMessage {
    private final String bankName;
    private final CreditMessage cmsg;

    public RuleMessage(String bankName, CreditMessage cmsg) {
        this.bankName = bankName;
        this.cmsg = cmsg;
    }

    public String getBankName() {
        return bankName;
    }

    public CreditMessage getCmsg() {
        return cmsg;
    }
    
    
}
