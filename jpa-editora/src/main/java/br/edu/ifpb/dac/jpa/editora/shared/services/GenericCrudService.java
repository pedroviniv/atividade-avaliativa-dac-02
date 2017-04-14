/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.editora.shared.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Pedro Arthur
 * @param <T> Entity Class
 * @param <E> Entity's Primary Key Class
 */
public class GenericCrudService<T, E> {
    
    protected EntityManager entityManager;
    private final Class<T> entityClassName;
    
    public GenericCrudService(Class<T> entityClasName, String persistenceUnit) {
        
        this.entityClassName = entityClasName;
        this.entityManager = Persistence
                .createEntityManagerFactory(persistenceUnit)
                .createEntityManager();     
    }
    
    public void persist(T obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
    }
    
    public void remove(T obj) {
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit();
    }
    
    public void update(T obj) {
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();
    }
    
    public T find(E key) {
        return entityManager.find(entityClassName, key);
    }
    
    public List<T> listAll() {
        StringBuilder builder = new StringBuilder();
        String tableName = entityClassName.getSimpleName();
        char tableNameFirstLetter = tableName.charAt(0);
        builder.append("SELECT ")
                .append(tableNameFirstLetter)
                .append(" FROM ")
                .append(tableName)
                .append(" ")
                .append(tableNameFirstLetter);
        System.out.println("QUERY: "+builder.toString());
        return entityManager.createQuery(builder.toString(), entityClassName)
                .getResultList();
    }
}
