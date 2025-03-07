package com.example.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cadastro.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {
    boolean existsByMatricula(Long matricula);
}