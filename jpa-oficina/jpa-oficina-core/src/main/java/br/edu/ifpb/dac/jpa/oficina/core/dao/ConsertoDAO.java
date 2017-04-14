/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.core.dao;

import br.edu.ifpb.dac.jpa.oficina.shared.domain.Conserto;

/**
 *
 * @author Pedro Arthur
 */
public interface ConsertoDAO {
    
    void save(Conserto conserto);
    Conserto get(Long consertoId);
    void remove(Conserto conserto);
}
