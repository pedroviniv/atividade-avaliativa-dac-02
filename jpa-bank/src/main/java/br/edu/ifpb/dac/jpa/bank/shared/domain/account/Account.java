/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.bank.shared.domain.account;

import br.edu.ifpb.dac.jpa.bank.shared.domain.Client;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Pedro Arthur
 */

@Entity
@DiscriminatorColumn(name = "account_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Account implements Serializable {
    
    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, 
        sequenceName = "account_id_sequence", 
        name = "account_sequence_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
            generator = "account_sequence_generator")
    private Long id;
    private Long number;
    private String agency;
    private Integer agencyDigit;
    private Integer accoutDigit;
    private String password;
    
    @OneToMany(fetch = FetchType.LAZY, 
            cascade = CascadeType.ALL, 
            mappedBy = "account")
    protected List<AccountEntry> entries;
    
    //DISCRIMINATOR COLUMN REUSING ENUM
    @Column(name = "account_type", nullable = false, insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private AccountType type;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_cpf")
    private Client client;

    public Account(Long number, String agency, Integer agencyDigit, Integer accoutDigit, String password, AccountType type, Client client) {
        this.number = number;
        this.agency = agency;
        this.agencyDigit = agencyDigit;
        this.accoutDigit = accoutDigit;
        this.password = password;
        this.type = type;
        this.client = client;
        this.entries = new ArrayList<>();
    }

    public Account() {
        this.entries = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public Integer getAgencyDigit() {
        return agencyDigit;
    }

    public void setAgencyDigit(Integer agencyDigit) {
        this.agencyDigit = agencyDigit;
    }

    public Integer getAccoutDigit() {
        return accoutDigit;
    }

    public void setAccoutDigit(Integer accoutDigit) {
        this.accoutDigit = accoutDigit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public BigDecimal getBalance() {
        BigDecimal balance = BigDecimal.ZERO;
        for(AccountEntry entry : entries) {
            balance = balance.add(entry.getValue());
        }
        return balance;
    }
    
    public List<AccountEntry> getAccountEntries() {
        return Collections.unmodifiableList(this.entries);
    }
    
    protected AccountEntry createAccountEntry(EntryType type, BigDecimal value) {
        return new AccountEntry(type, value, this, LocalDateTime.now());
    }
    
    public abstract void debit(BigDecimal value) throws AccountException;
    public abstract void credit(BigDecimal value);

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", number=" + number + ", agency=" + agency + ", agencyDigit=" + agencyDigit + ", accoutDigit=" + accoutDigit + ", password=" + password + ", type=" + type + ", client=" + client + '}';
    }
}
