/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.core.services;

import br.edu.ifpb.dac.jpa.oficina.core.dao.ConsertoDAO;
import br.edu.ifpb.dac.jpa.oficina.shared.domain.Conserto;
import br.edu.ifpb.dac.jpa.oficina.shared.services.interfaces.ConsertoService;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Pedro Arthur
 */


@Remote(ConsertoService.class)
@Stateless
public class ConsertoServiceImpl implements ConsertoService {
    
    @EJB
    private ConsertoDAO consertoDAO;

    @Override
    public void novoConserto(Conserto conserto) {
        this.consertoDAO.save(conserto);
    }

    @Override
    public void removerConserto(Conserto conserto) {
        Conserto target = consertoDAO.get(conserto.getId());
        this.consertoDAO.remove(target);
    }
    
    @Override
    public Conserto buscarPorId(Long id) {
        return consertoDAO.get(id);
    }
    
}
