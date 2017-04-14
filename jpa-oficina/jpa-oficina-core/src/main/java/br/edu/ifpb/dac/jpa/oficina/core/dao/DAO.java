/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.core.dao;

import java.util.List;

/**
 *
 * @author Pedro Arthur
 */
public interface DAO<T, E> {
    
    void persist(T obj);
    void remove(T obj);
    void update(T obj);
    T find(E pk);
    List<T> listAll();
    
}
