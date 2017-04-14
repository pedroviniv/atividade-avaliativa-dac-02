/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.core.dao;

import br.edu.ifpb.dac.jpa.oficina.shared.domain.Funcionario;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pedro Arthur
 */

@Local(FuncionarioDAO.class)
@Stateless
public class FuncionarioDAOJpaImpl implements FuncionarioDAO {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void remove(Funcionario funcionario) {
        this.entityManager.remove(funcionario);
    }

    @Override
    public Funcionario get(Long id) {
        return this.entityManager.find(Funcionario.class, id);
    }

    @Override
    public void save(Funcionario funcionario) {
        this.entityManager.persist(funcionario);
    }
    
}
