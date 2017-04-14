/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.editora.shared.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Pedro Arthur
 */

@Entity
public class Livro implements Serializable {
    
    @Id
    private String ISBN;
    private String titulo;
    private LocalDate lancamento;
    
    @ManyToMany(
        fetch = FetchType.LAZY,
        mappedBy = "livros"
    )
    private final List<Autor> autores;

    public Livro(String ISBN, String titulo, LocalDate lancamento) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.lancamento = lancamento;
        this.autores = new ArrayList<>();
    }

    public Livro() {
        this.autores = new ArrayList<>();
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public List<Autor> getAutores() {
        return Collections.unmodifiableList(this.autores);
    }

    @Override
    public String toString() {
        return "Livro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", lancamento=" + lancamento + '}';
    }
}
