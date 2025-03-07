package com.example.cadastro.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

@Entity
public class Professor extends PessoaFisica {
    @Column(unique = true, nullable = false, length = 10)
    private Long matricula; // Número de 10 dígitos, único
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

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
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
