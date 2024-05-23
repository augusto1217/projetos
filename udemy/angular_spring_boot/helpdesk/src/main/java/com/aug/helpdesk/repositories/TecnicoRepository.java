package com.aug.helpdesk.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aug.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, BigInteger> {

}
