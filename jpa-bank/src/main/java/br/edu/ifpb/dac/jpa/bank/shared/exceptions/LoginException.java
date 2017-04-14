/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.bank.shared.exceptions;

/**
 *
 * @author Pedro Arthur
 */
public class LoginException extends Exception {
    
    public LoginException(String msg) {
        super(msg);
    }
    
}
