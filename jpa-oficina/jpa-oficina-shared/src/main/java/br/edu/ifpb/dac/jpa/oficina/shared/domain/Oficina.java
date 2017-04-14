/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.oficina.shared.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;

/**
 *
 * @author Pedro Arthur
 */

@Entity
public class Oficina implements Serializable {
    
    public static int UUID = 123214123;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String descricao;
    @Embedded
    private Endereco endereco;
    private BigDecimal saldo;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "oficina_id")
    private List<Funcionario> funcionarios;

    public Oficina(String descricao, Endereco endereco, BigDecimal saldo) {
        this.descricao = descricao;
        this.endereco = endereco;
        this.saldo = saldo;
        this.funcionarios = new ArrayList<>();
    }
    
    public Oficina() {
        this.funcionarios = new ArrayList<>();
    }
    
    @PostLoad
    public void method() {
        System.out.println(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Funcionario> getFuncionarios() {
        return Collections.unmodifiableList(this.funcionarios);
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }
    
    public void removerFuncionario(Funcionario funcionario) {
        this.funcionarios.remove(funcionario);
    }

    @Override
    public String toString() {
        return "Oficina{" + "id=" + id + ", descricao=" + descricao + ", endereco=" + endereco + ", saldo=" + saldo + ", funcionarios=" + funcionarios + '}';
    }
}
