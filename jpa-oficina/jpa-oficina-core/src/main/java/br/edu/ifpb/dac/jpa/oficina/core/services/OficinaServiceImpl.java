/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.core.services;

import br.edu.ifpb.dac.jpa.oficina.core.dao.OficinaDAO;
import br.edu.ifpb.dac.jpa.oficina.shared.domain.Funcionario;
import br.edu.ifpb.dac.jpa.oficina.shared.domain.Oficina;
import br.edu.ifpb.dac.jpa.oficina.shared.services.interfaces.OficinaService;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Pedro Arthur
 */

@Remote(OficinaService.class)
@Stateless
public class OficinaServiceImpl implements OficinaService {
    
    @EJB
    private OficinaDAO oficinaDAO;

    @Override
    public Oficina novaOficina(Oficina oficina) {
        this.oficinaDAO.save(oficina);
        return oficina;
    }

    @Override
    public void alocarFuncionario(Oficina oficina, Funcionario funcionario) { 
        oficina.adicionarFuncionario(funcionario);
        oficinaDAO.update(oficina);
    }
    
    @Override
    public Oficina buscarOficinaPorId(Long id) {
        Oficina oficina = oficinaDAO.get(id);
        return oficina;
    }
    
}
