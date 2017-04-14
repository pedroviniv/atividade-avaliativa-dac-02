/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.editora.shared.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Pedro Arthur
 */

@Embeddable
public class Endereco implements Serializable {
    
    private String rua;
    private String bairro;
    private String cidade;
    private String CEP;

    public Endereco(String rua, String bairro, String cidade, String CEP) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.CEP = CEP;
    }

    public Endereco() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    @Override
    public String toString() {
        return "Endereco{" + "rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", CEP=" + CEP + '}';
    }
}
