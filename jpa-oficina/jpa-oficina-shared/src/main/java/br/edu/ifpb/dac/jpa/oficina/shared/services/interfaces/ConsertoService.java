/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.shared.services.interfaces;

import br.edu.ifpb.dac.jpa.oficina.shared.domain.Conserto;

/**
 *
 * @author Pedro Arthur
 */
public interface ConsertoService {
    
    void novoConserto(Conserto conserto);
    void removerConserto(Conserto conserto);
    Conserto buscarPorId(Long id);
}
