/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.editora.shared.domain.telefone;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
/**
 *
 * @author Pedro Arthur
 */

@Entity
@SequenceGenerator(
    initialValue = 1, 
    allocationSize = 1, 
    name = "telefone_seq_gen",
    sequenceName = "telefone_id_seq"
)
public class Telefone implements Serializable {

    
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "telefone_seq_gen"
    )
    private Long id;
    
    private String numero;
  
    @Enumerated(EnumType.STRING)
    private TelefoneType type;

    public Telefone(String numero, TelefoneType type) {
        this.numero = numero;
        this.type = type;
    }

    public Telefone() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TelefoneType getType() {
        return type;
    }

    public void setType(TelefoneType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Telefone{numero=" + numero + ", type=" + type + '}';
    }
}
