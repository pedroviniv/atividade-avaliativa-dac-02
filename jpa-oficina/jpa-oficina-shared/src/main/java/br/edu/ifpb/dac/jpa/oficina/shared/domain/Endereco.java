/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.shared.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Pedro Arthur
 */

@Embeddable
public class Endereco implements Serializable {
    
    private String cidade;
    private String bairro;
    private String rua;

    public Endereco(String cidade, String bairro, String rua) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }
    
    public Endereco() {
        
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public String toString() {
        return "Endereco{" + "cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua + '}';
    }
}
