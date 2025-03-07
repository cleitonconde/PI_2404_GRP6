
package com.example.cadastro.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class PessoaFisica extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String cpf;
    private String rg;

    public PessoaFisica() {
        // Construtor sem argumentos necessário para desserialização
    }

    public PessoaFisica(String nome, LocalDate dataNascimento, String cpf, String rg) {
        super(nome, dataNascimento);
        this.cpf = cpf;
        this.rg = rg;
    }

    public boolean validarCpfExistente(String cpf) {
        // Implementação futura para verificar se CPF já existe no banco
        return false;
    }

    // Getters e Setters

    @Override
    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
