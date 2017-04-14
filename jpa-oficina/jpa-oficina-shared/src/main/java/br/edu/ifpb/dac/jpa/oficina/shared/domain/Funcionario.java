/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.shared.domain;

import br.edu.ifpb.dac.jpa.oficina.shared.domain.enums.Funcao;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Pedro Arthur
 */

@Entity
public class Funcionario implements Serializable {
    
    public static int UUID = 1041231234;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String nome;
    private String cpf;
    private String rg;
    private BigDecimal salario;
    
    @Enumerated(EnumType.STRING)
    private Funcao funcao;

    public Funcionario(String nome, String cpf, String rg, BigDecimal salario, Funcao funcao) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.cpf);
        hash = 83 * hash + Objects.hashCode(this.rg);
        hash = 83 * hash + Objects.hashCode(this.salario);
        hash = 83 * hash + Objects.hashCode(this.funcao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.salario, other.salario)) {
            return false;
        }
        if (this.funcao != other.funcao) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", salario=" + salario + ", funcao=" + funcao + '}';
    }
}
