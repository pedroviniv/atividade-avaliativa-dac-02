/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.core.dao;

import br.edu.ifpb.dac.jpa.oficina.shared.domain.Oficina;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pedro Arthur
 */

@Local(OficinaDAO.class)
@Stateless
public class OficinaDAOJpaImpl implements OficinaDAO {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Oficina oficina) {
        this.entityManager.persist(oficina);
    }

    @Override
    public void update(Oficina updatedOficina) {
        this.entityManager.merge(updatedOficina);
    }

    @Override
    public Oficina get(Long id) {
        Oficina found = this.entityManager.find(Oficina.class, id);
        return found;
    }
    
}
