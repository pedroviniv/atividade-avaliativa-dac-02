/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.bank.shared.domain.account;

import br.edu.ifpb.dac.jpa.bank.shared.domain.Client;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

/**
 *
 * @author Pedro Arthur
 */

@Entity
@DiscriminatorValue(value = "SAVING")
public class SavingAccount extends Account {
    
    @Transient
    private static final Double CREDIT_INCREMENT = 0.56D;

    public SavingAccount(Long number, String agency, Integer agencyDigit, Integer accoutDigit, String password, Client client) {
        super(number, agency, agencyDigit, accoutDigit, password, AccountType.SAVING, client);
    }
    
    public SavingAccount() {
        super();
    }

    @Override
    public void debit(BigDecimal value) throws AccountException {
        
        if(value.doubleValue() <= 0) 
            throw new IllegalArgumentException("You can't debit a value less or equal to 0.");
        
        if(super.getBalance().doubleValue() <= value.doubleValue())
            throw new AccountException("Not balance enought!");
        
        AccountEntry accountEntry = super.createAccountEntry(EntryType.DEBIT,
                value.multiply(new BigDecimal(-1d)));
         
        super.entries.add(accountEntry);
    }

    @Override
    public void credit(BigDecimal value) {
        
        if(value.doubleValue() <= 0) throw new IllegalArgumentException("You can't debit a value less or equal to 0.");
        
        AccountEntry accountEntry = 
                super.createAccountEntry(EntryType.CREDIT, value);
        
        super.entries.add(accountEntry);
        
        AccountEntry incrementCreditEntry = 
                super.createAccountEntry(EntryType.CREDIT, 
                        new BigDecimal(CREDIT_INCREMENT));
        
        super.entries.add(incrementCreditEntry);
    }
    
}
