package com.example.cadastro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cadastro.model.PessoaJuridica;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {
    @Query("SELECT pj FROM PessoaJuridica pj WHERE pj.cnpj = :cnpj")
    Optional<PessoaJuridica> findByCnpj(String cnpj);

    List<PessoaJuridica> findByNomeContaining(String nome);
}
