package com.example.cadastro.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

@Entity
public class Fornecedor extends PessoaJuridica {
    @ElementCollection
    private List<String> produtosFornecidos;
    private String condicaoPagamento;

    public Fornecedor(String nome, String razaoSocial, String cnpj, String inscricaoEstadual) {
        super(nome, razaoSocial, cnpj, inscricaoEstadual);
    }

    // Getters e Setters
    public List<String> getProdutosFornecidos() {
        return produtosFornecidos;
    }

    public void setProdutosFornecidos(List<String> produtosFornecidos) {
        this.produtosFornecidos = produtosFornecidos;
    }

    public String getCondicaoPagamento() {
        return condicaoPagamento;
    }

    public void setCondicaoPagamento(String condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }
}
