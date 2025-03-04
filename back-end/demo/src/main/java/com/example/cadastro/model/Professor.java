package com.example.cadastro.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Professor extends PessoaFisica {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;
    @ElementCollection
    private List<String> formacoes;
    @ElementCollection
    private List<String> disciplinas;

    public void atribuirDisciplina(String disciplina) {
        this.disciplinas.add(disciplina);
    }

    // Getters e Setters
    public Long getMatricula() {
        return matricula;
    }

    public List<String> getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(List<String> formacoes) {
        this.formacoes = formacoes;
    }

    public List<String> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<String> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
