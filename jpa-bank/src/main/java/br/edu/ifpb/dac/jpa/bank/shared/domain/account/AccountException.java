/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.bank.shared.domain.account;

/**
 *
 * @author Pedro Arthur
 */
public class AccountException extends RuntimeException {
    
    public AccountException(String msg) {
        super(msg);
    }
}
