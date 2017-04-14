/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.jse.producers;

import br.edu.ifpb.dac.jpa.oficina.shared.services.interfaces.FuncionarioService;

/**
 *
 * @author Pedro Arthur
 */
public class FuncionarioServiceProducer {
    private static final String RESOURCE = "java:global/jpa-oficina-core/FuncionarioServiceImpl!br.edu.ifpb.dac.jpa.oficina.shared.services.interfaces.FuncionarioService";
    
    public static FuncionarioService getInstance() {
        return new ServiceLocator().lookup(RESOURCE, FuncionarioService.class);
    }
}
