package com.example.cadastro.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PessoaFisica3 {

    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Garante o formato correto
    private LocalDate dataNascimento;

    private String documento;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", documento='" + documento + '\'' +
                '}';
    }
}
