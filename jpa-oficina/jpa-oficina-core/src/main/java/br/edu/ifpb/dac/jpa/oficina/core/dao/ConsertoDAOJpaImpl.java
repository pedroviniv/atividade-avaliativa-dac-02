/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.core.dao;

import br.edu.ifpb.dac.jpa.oficina.shared.domain.Conserto;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pedro Arthur
 */

@Local(ConsertoDAO.class)
@Stateless
public class ConsertoDAOJpaImpl implements ConsertoDAO {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Conserto conserto) {
        this.entityManager.persist(conserto);
    }
    
    @Override
    public Conserto get(Long consertoId) {
        Conserto found = this.entityManager.find(Conserto.class, consertoId);
        return found;
    }

    @Override
    public void remove(Conserto conserto) {
        this.entityManager.remove(conserto);
    }
    
}
