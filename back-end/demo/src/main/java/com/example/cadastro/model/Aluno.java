package com.example.cadastro.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Aluno extends PessoaFisica {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;
    @ElementCollection
    private List<String> cursos;

    public void matricularAluno(String curso) {
        this.cursos.add(curso);
    }

    public List<String> consultarHistorico() {
        return this.cursos;
    }

    // Getters e Setters
    public Long getMatricula() {
        return matricula;
    }

    public List<String> getCursos() {
        return cursos;
    }

    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }
}
