package com.aug.helpdesk.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aug.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, BigInteger> {

    
} 
