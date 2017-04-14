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
public enum AccountType {
    
    SAVING("Poupança"), 
    CURRENT("Corrente");
    
    /**
     * 
     * if(accountType.equals(accountType.SAVING) {
     *      strategy = new SavingAccountStrategy();
     * 
     */
    
    private final String description;
    
    AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
