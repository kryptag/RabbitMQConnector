/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kryptag.rabbitmqconnector.MessageClasses;

import java.util.ArrayList;

/**
 *
 * @author florenthaxha
 */
public class RuleMessage {
    private final ArrayList<String> bankName;
    private final CreditMessage cmsg;

    public RuleMessage(ArrayList<String> bankName, CreditMessage cmsg) {
        this.bankName = bankName;
        this.cmsg = cmsg;
    }

    public ArrayList<String> getBankNames() {
        return bankName;
    }

    public CreditMessage getCmsg() {
        return cmsg;
    }
    
    
}
