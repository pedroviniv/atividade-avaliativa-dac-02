/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.bank.shared.domain.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Pedro Arthur
 */

@Entity
@Table(name = "account_entry")
@SequenceGenerator(initialValue = 10000, allocationSize = 1, 
        sequenceName = "account_entry_id_sequence",
        name = "account_entry_sequence_generator")
public class AccountEntry implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "account_entry_sequence_generator")
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private EntryType type;
    
    @Column(precision = 11, scale = 2)
    private BigDecimal value;
    
    
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    
    private LocalDateTime dateTime;
    
    public AccountEntry(EntryType type, BigDecimal value, Account account, LocalDateTime dateTime) {
        this.type = type;
        this.value = value;
        this.account = account;
        this.dateTime = dateTime;
    }
    
    public AccountEntry() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EntryType getType() {
        return type;
    }

    public void setType(EntryType type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Entry{" + "id=" + id + ", value=" + value + ", account=" + account + '}';
    }
}
