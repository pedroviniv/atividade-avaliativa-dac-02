/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.editora.shared.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Pedro Arthur
 */

@Entity
@DiscriminatorValue("AUTOR")
public class Autor extends Pessoa {
    
    private String instituicaoVinculada;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "autor_livro", 
        joinColumns = 
            @JoinColumn(name = "autor_cpf"),
        inverseJoinColumns = 
            @JoinColumn(name = "livro_isbn")   
    )
    private final List<Livro> livros;

    public Autor(String instituicaoVinculada, String cpf, String nome, LocalDate dataNascimento, Endereco endereco) {
        super(cpf, nome, dataNascimento, endereco);
        this.instituicaoVinculada = instituicaoVinculada;
        this.livros = new ArrayList<>();
    }

    public Autor() {
        super();
        this.livros = new ArrayList<>();
    }

    public String getInstituicaoVinculada() {
        return instituicaoVinculada;
    }

    public void setInstituicaoVinculada(String instituicaoVinculada) {
        this.instituicaoVinculada = instituicaoVinculada;
    }
    
    public List<Livro> getLivros() {
        return Collections.unmodifiableList(this.livros);
    }
    
    public void addLivro(Livro livro) {
        this.livros.add(livro);
    }
    
    public void removeLivro(Livro livro) {
        this.livros.remove(livro);
    }

    @Override
    public String toString() {
        return "Autor{" + "instituicaoVinculada=" + instituicaoVinculada + '}';
    }
}
