/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.bank.shared.services;

import br.edu.ifpb.dac.jpa.bank.shared.domain.account.Account;
import br.edu.ifpb.dac.jpa.bank.shared.domain.account.AccountEntry;
import br.edu.ifpb.dac.jpa.bank.shared.domain.account.AccountException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Pedro Arthur
 */
public class AccountService extends GenericCrudService<Account, Long> {

    public AccountService() {
        super(Account.class, "jpa-bank-pu");
    }
    
    public void debit(Account account, BigDecimal value) throws AccountException {
        account.debit(value);
        update(account);
    }
    
    public void credit(Account account, BigDecimal value) {
        account.credit(value);
        update(account);
    }
    
    public List<AccountEntry> getExtrato(Long id) {
        Account account = find(id);
        if(account == null)
            return Collections.EMPTY_LIST;
        return account.getAccountEntries();
    }
}
