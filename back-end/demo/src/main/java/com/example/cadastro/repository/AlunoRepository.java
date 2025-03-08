package com.example.cadastro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cadastro.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByCpf(String cpf);

    boolean existsByMatricula(Long matricula);

    @Query("SELECT MAX(a.matricula) FROM Aluno a")
    Optional<Long> findMaxMatricula();
}
