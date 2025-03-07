package com.example.cadastro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.cadastro.model.PessoaFisica;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, String> {
    @Query("SELECT pf FROM PessoaFisica pf WHERE pf.cpf = :cpf")
    Optional<PessoaFisica> findByCpf(@Param("cpf") String cpf);

    List<PessoaFisica> findByNomeContaining(String nome);
}
