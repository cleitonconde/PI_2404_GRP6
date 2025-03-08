package com.example.cadastro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cadastro.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {
    Optional<Professor> findByCpf(String cpf);

    boolean existsByMatricula(Long matricula);

    @Query("SELECT MAX(a.matricula) FROM Aluno a")
    Optional<Long> findMaxMatricula();
}
