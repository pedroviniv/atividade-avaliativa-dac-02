/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.jse.producers;

import br.edu.ifpb.dac.jpa.oficina.shared.services.interfaces.OficinaService;

/**
 *
 * @author Pedro Arthur
 */
public class OficinaServiceProducer {
    
    private static final String RESOURCE = "java:global/jpa-oficina-core/OficinaServiceImpl!br.edu.ifpb.dac.jpa.oficina.shared.services.interfaces.OficinaService";
    
    public static OficinaService getInstance() {
        return new ServiceLocator().lookup(RESOURCE, OficinaService.class);
    }
}
