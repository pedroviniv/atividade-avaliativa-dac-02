/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.bank.shared.domain;

import br.edu.ifpb.dac.jpa.bank.shared.domain.account.Account;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Pedro Arthur
 */

@Entity
public class Client implements Serializable {
    
    @Id
    private String cpf;
    private String rg;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String phone;
    
    @Embedded
    private Address address;
    
    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Account account;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User user;

    public Client(String cpf, String rg, String firstname, String lastname, 
            LocalDate birthdate, String phone, Address address, User user) {
        this.cpf = cpf;
        this.rg = rg;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.address = address;
        this.user = user;
    }

    public Client() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Client{" + "cpf=" + cpf + ", rg=" + rg + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate + ", phone=" + phone + ", address=" + address + ", user=" + user + '}';
    }
}
