package com.aug.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aug.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    
} 
