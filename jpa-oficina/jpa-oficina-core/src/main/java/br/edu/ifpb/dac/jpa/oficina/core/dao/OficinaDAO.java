/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.core.dao;

import br.edu.ifpb.dac.jpa.oficina.shared.domain.Oficina;

/**
 *
 * @author Pedro Arthur
 */
public interface OficinaDAO {
    
    void save(Oficina oficina);
    void update(Oficina updatedOficina);
    Oficina get(Long id);
}
