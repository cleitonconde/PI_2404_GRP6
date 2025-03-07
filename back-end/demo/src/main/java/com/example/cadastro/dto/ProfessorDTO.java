package com.example.cadastro.dto;

import java.util.List;

public class ProfessorDTO {
    private String cpf;
    private List<String> formacoes;
    private List<String> disciplinas;

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
