/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.editora.shared.main;

import br.edu.ifpb.dac.jpa.editora.shared.domain.Aluno;
import br.edu.ifpb.dac.jpa.editora.shared.domain.Autor;
import br.edu.ifpb.dac.jpa.editora.shared.domain.Endereco;
import br.edu.ifpb.dac.jpa.editora.shared.domain.Livro;
import br.edu.ifpb.dac.jpa.editora.shared.domain.Professor;
import br.edu.ifpb.dac.jpa.editora.shared.domain.telefone.TelefoneType;
import br.edu.ifpb.dac.jpa.editora.shared.services.GenericCrudService;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Pedro Arthur
 */
public class App {
    
    private static GenericCrudService<Autor, String> autorCrud;
    private static GenericCrudService<Professor, String> professorCrud;
    private static GenericCrudService<Aluno, String> alunoCrud;
    
    public static void main(String[] args) {
        
        autorCrud = new GenericCrudService<>(Autor.class, "jpa-editora-pu");
        professorCrud = new GenericCrudService<>(Professor.class, "jpa-editora-pu");
        alunoCrud = new GenericCrudService<>(Aluno.class, "jpa-editora-pu");
        
        
        addAutor();
        addLivro();
        addProfessor();
        addTelefones();
        addAluno();
    }
    
    private static void addAutor() {
        Autor autor = new Autor("IFPB", "111.222.333-44", "Pedro Arthur", LocalDate.now(), new Endereco("", "", "", ""));
        autorCrud.persist(autor);
    }
    
    private static void addLivro() {
        Livro livro = new Livro("12312451231", "Java 9: Uma evolução necessária", LocalDate.now());
        Autor found = autorCrud.find("111.222.333-44");
        found.addLivro(livro);
        autorCrud.update(found);
    }
    
    private static void addProfessor() {
        Professor p = new Professor(BigDecimal.valueOf(2000d), "222.333.444-55", "Pedro Arthur", LocalDate.now(), new Endereco("", "", "", ""));
        professorCrud.persist(p);
    }
    
    private static void addTelefones() {
        Professor professor = professorCrud.find("222.333.444-55");
        professor.addTelefone("(83)99999-9999", TelefoneType.COMERCIAL);
        professor.addTelefone("(83)99193-9449", TelefoneType.RESIDENCIAL);
        professorCrud.update(professor);
    }
    
    private static void addAluno() {
        Aluno aluno = new Aluno("201413322244", LocalDate.now(), "2014.1", "333.444.555-66", "Fulano", LocalDate.now(), new Endereco("", "", "", ""));
        alunoCrud.persist(aluno);
    }
}
