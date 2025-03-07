package com.example.cadastro.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

@Entity
public class Aluno extends PessoaFisica {
    @Column(unique = true, nullable = false, length = 10)
    private Long matricula; // Número de 10 dígitos, único

    @ElementCollection
    private List<String> cursos = new ArrayList<>(); // Evita NullPointerException

    // Construtor padrão
    public Aluno() {
    }

    // Construtor com parâmetros
    public Aluno(Long matricula) {
        setMatricula(matricula);
    }

    // Método para matricular o aluno em um curso
    public void matricularAluno(String curso) {
        if (curso != null && !curso.isEmpty()) {
            this.cursos.add(curso);
        }
    }

    // Método para consultar histórico de cursos
    public List<String> consultarHistorico() {
        return new ArrayList<>(this.cursos); // Evita modificar a lista original externamente
    }

    // Getters e Setters
    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        if (matricula != null && String.valueOf(matricula).length() == 10) {
            this.matricula = matricula;
        } else {
            throw new IllegalArgumentException("A matrícula deve ter exatamente 10 dígitos.");
        }
    }

    public List<String> getCursos() {
        return new ArrayList<>(cursos); // Evita modificações externas diretas
    }

    public void setCursos(List<String> cursos) {
        this.cursos = (cursos != null) ? new ArrayList<>(cursos) : new ArrayList<>();
    }
}
