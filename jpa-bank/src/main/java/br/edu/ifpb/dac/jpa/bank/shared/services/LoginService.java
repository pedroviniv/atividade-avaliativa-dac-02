/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.bank.shared.services;

import br.edu.ifpb.dac.jpa.bank.shared.domain.User;
import br.edu.ifpb.dac.jpa.bank.shared.exceptions.LoginException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Pedro Arthur
 */
public class LoginService {
    
    private final EntityManager entityManager;
    
    public LoginService() {
        this.entityManager = Persistence
                .createEntityManagerFactory("jpa-bank-pu")
                .createEntityManager();     
    }
    
    public User login(String username, String password) throws LoginException {
        String sql = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
        TypedQuery<User> createQuery = entityManager
                .createQuery(sql, User.class)
                .setParameter("password", password)
                .setParameter("username", username);
        try {
            User user = createQuery.getSingleResult();
            return user;
        } catch (NoResultException ex) {
            throw new LoginException("Usuário e/ou Senha incorreto(s)!");
        }
    }
}
