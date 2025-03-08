package com.example.cadastro.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

@Entity
public class Professor extends PessoaFisica {
    @Column(unique = true, nullable = false, length = 10)
    private Long matricula; // Número de 10 dígitos, único
    @ElementCollection
    private List<String> formacoes = new ArrayList<>(); // Inicializando a lista
    /*
     * @ElementCollection
     * private List<String> disciplinas = new ArrayList<>(); // Inicializando a
     * lista
     */

    /*
     * public void atribuirDisciplina(String disciplina) {
     * this.disciplinas.add(disciplina);
     * }
     */
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

    /*
     * public List<String> getDisciplinas() {
     * return disciplinas;
     * }
     * 
     * public void setDisciplinas(List<String> disciplinas) {
     * this.disciplinas = disciplinas;
     * }
     */
    public void matricularProfessorFormacao(String formacao) {
        if (formacao != null && !formacao.isEmpty()) {
            this.formacoes.add(formacao);
        }
    }

    /*
     * public void matricularProfessorDisciplina(String disciplina) {
     * if (disciplina != null && !disciplina.isEmpty()) {
     * this.disciplinas.add(disciplina);
     * }
     * }
     */
}
