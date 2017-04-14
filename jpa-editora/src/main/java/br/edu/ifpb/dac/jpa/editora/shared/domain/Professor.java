/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.editora.shared.domain;

import br.edu.ifpb.dac.jpa.editora.shared.domain.telefone.Telefone;
import br.edu.ifpb.dac.jpa.editora.shared.domain.telefone.TelefoneType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Pedro Arthur
 */

@Entity
@DiscriminatorValue(value = "PROFESSOR")
public class Professor extends Pessoa {
    
    private BigDecimal salario;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_cpf")
    private final List<Telefone> telefones;    

    public Professor(BigDecimal salario, String cpf, String nome, LocalDate dataNascimento, Endereco endereco) {
        super(cpf, nome, dataNascimento, endereco);
        this.salario = salario;
        this.telefones = new ArrayList<>();
    }

    public Professor() {
        this.telefones = new ArrayList<>();
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public List<Telefone> getTelefones() {
        return Collections.unmodifiableList(this.telefones);
    }
    
    public void addTelefone(String numero, TelefoneType tipo) {
        Telefone telefone = new Telefone(numero, tipo);
        this.telefones.add(telefone);
    }
    
    public void removeTelefone(Telefone telefone) {
        telefones.remove(telefone);
    }

    @Override
    public String toString() {
        return "Professor{" + "salario=" + salario + '}';
    }
}
