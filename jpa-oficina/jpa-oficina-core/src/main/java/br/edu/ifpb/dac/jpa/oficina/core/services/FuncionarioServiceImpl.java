/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.core.services;

import br.edu.ifpb.dac.jpa.oficina.core.dao.FuncionarioDAO;
import br.edu.ifpb.dac.jpa.oficina.shared.domain.Funcionario;
import br.edu.ifpb.dac.jpa.oficina.shared.services.interfaces.FuncionarioService;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Pedro Arthur
 */

@Remote(FuncionarioService.class)
@Stateless
public class FuncionarioServiceImpl implements FuncionarioService {
    
    @EJB
    private FuncionarioDAO funcionarioDAO;
    
    @Override
    public void novoFuncionario(Funcionario funcionario) {
        this.funcionarioDAO.save(funcionario);
    }
    
    @Override
    public Funcionario buscarFuncionarioPorId(Long id) {
        return funcionarioDAO.get(id);
    } 
}
