/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.editora.shared.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Pedro Arthur
 */


@Entity
@DiscriminatorValue(value = "ALUNO")
public class Aluno extends Pessoa {
    
    @Column(unique = true)
    private String matricula;
    private LocalDate dataIngresso;
    private String turma;

    public Aluno(String matricula, LocalDate dataIngresso, String turma, String cpf, String nome, LocalDate dataNascimento, Endereco endereco) {
        super(cpf, nome, dataNascimento, endereco);
        this.matricula = matricula;
        this.dataIngresso = dataIngresso;
        this.turma = turma;
    }

    public Aluno() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", dataIngresso=" + dataIngresso + ", turma=" + turma + '}';
    }
}
