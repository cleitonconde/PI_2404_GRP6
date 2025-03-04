
package com.example.cadastro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PessoaFisica extends Pessoa {
    @Column(nullable = false, unique = true)
    private String cpf;
    private String rg;

    public boolean validarCpfExistente(String cpf) {
        // Implementação futura para verificar se CPF já existe no banco
        return false;
    }

    // Getters e Setters
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
