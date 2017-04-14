/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.editora.shared.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

/**
 *
 * @author Pedro Arthur
 */

@Inheritance(strategy = InheritanceType.JOINED) 
@DiscriminatorColumn(name = "pessoa_type")
@Entity
public class Pessoa implements Serializable {
    
    
    @Id
    private String cpf;
    private String nome;
    
    @Transient
    private int idade;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Embedded
    private Endereco endereco;

    public Pessoa(String cpf, String nome, LocalDate dataNascimento, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Pessoa() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        LocalDate now = LocalDate.now();
        Period p = Period.between(this.dataNascimento, now);
        this.idade = p.getYears();
        return this.idade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "cpf=" + cpf + ", nome=" + nome + ", idade=" + this.getIdade() + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + '}';
    }
    
    
}
