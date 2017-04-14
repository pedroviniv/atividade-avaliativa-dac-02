/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.jse.producers;

import br.edu.ifpb.dac.jpa.oficina.shared.services.interfaces.ConsertoService;

/**
 *
 * @author Pedro Arthur
 */
public class ConsertoServiceProducer {
    private static final String RESOURCE = "java:global/jpa-oficina-core/ConsertoServiceImpl!br.edu.ifpb.dac.jpa.oficina.shared.services.interfaces.ConsertoService";
    
    public static ConsertoService getInstance() {
        return new ServiceLocator().lookup(RESOURCE, ConsertoService.class);
    }
}
