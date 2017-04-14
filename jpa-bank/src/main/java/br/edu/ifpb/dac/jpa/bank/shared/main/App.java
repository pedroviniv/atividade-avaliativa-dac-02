/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.bank.shared.main;

import br.edu.ifpb.dac.jpa.bank.shared.domain.Client;
import br.edu.ifpb.dac.jpa.bank.shared.domain.User;
import br.edu.ifpb.dac.jpa.bank.shared.domain.account.Account;
import br.edu.ifpb.dac.jpa.bank.shared.domain.account.AccountEntry;
import br.edu.ifpb.dac.jpa.bank.shared.domain.account.SavingAccount;
import br.edu.ifpb.dac.jpa.bank.shared.exceptions.LoginException;
import br.edu.ifpb.dac.jpa.bank.shared.services.AccountService;
import br.edu.ifpb.dac.jpa.bank.shared.services.GenericCrudService;
import br.edu.ifpb.dac.jpa.bank.shared.services.LoginService;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Pedro Arthur
 */
public class App {
    
    private static AccountService accountService;
    private static GenericCrudService<Client, String> clientService;
    private static LoginService loginService;
    
    public static void main(String[] args) {
        
        accountService = new AccountService();
        clientService = new GenericCrudService<>(Client.class, "jpa-bank-pu");
        loginService = new LoginService();
        
        adicionarCliente();
        exibirCliente();
        login();
        atualizarCliente();
        exibirCliente();
        adicionarConta();
        alterarSenhaConta();
        depositar();
        sacar();
        gerarExtrato();
        getSaldo();
        removerConta();
        
    }
    
    private static void login() {
        try {
            User loggedUser = loginService.login("fulano@gmail.com", "123456");
            System.out.println("LoggedUser: "+loggedUser);
        } catch (LoginException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private static void adicionarCliente() {
        
        Client cliente = new Client();
        cliente.setRg("111.222.333");
        cliente.setCpf("111.222.333-44");
        cliente.setFirstname("Fulano");
        cliente.setLastname("Sicrano");
        cliente.setPhone("99999-9999");
        cliente.setBirthdate(LocalDate.now());
        
        User user = new User("fulano@gmail.com", "123456");
        cliente.setUser(user);
        
        clientService.persist(cliente);
    }
    
    private static void atualizarCliente() {
        
        Client found = clientService.find("111.222.333-44");
        found.setPhone("88888-8888");
        found.setBirthdate(LocalDate.of(1980, 8, 5));
        
        clientService.update(found);
    }
    
    private static void exibirCliente() {
        
        Client found = clientService.find("111.222.333-44");
        System.out.println("Cliente found: "+found);
    }
    
    private static void adicionarConta() {
        
        Client found = clientService.find("111.222.333-44");
        
        Account account = new SavingAccount();
        account.setAccoutDigit(1000300);
        account.setAgency("Banco do Brasil");
        account.setAgencyDigit(34343434);
        account.setNumber(100200300L);
        account.setPassword("123456789");
        
        account.setClient(found);
        
        accountService.persist(account);
    }
    
    private static void alterarSenhaConta() {
        
        Account account = accountService.find(1L);
        account.setPassword("321654987");
        
        accountService.update(account);
    }
    
    private static void removerConta() {
        Account account = accountService.find(1L);
        
        accountService.remove(account);
    }
    
    private static void depositar() {
        Account account = accountService.find(1L);
        accountService.credit(account, BigDecimal.valueOf(2000d));
    }
    
    private static void sacar() {
        Account account = accountService.find(1L);
        accountService.debit(account, BigDecimal.valueOf(550d));
    }
    
    private static void gerarExtrato() {
        Account account = accountService.find(1L);
        System.out.println("===EXTRATO===");
        for(AccountEntry entry : account.getAccountEntries()) {
            System.out.println("ID ["+entry.getId()+"] {");
            System.out.println("\t tipo:"+entry.getType()+", ");
            System.out.println("\t data: "+entry.getDateTime()+", ");
            System.out.println("\t valor: R$ "+entry.getValue()+" ");
            System.out.println("} ");
        }
    }
    
    private static void getSaldo() {
        Account account = accountService.find(1L);
        System.out.println("SALDO: R$ "+account.getBalance());
    }
    
    
}
