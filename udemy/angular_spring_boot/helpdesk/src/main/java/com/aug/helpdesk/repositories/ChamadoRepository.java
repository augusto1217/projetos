package com.aug.helpdesk.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aug.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, BigInteger> {

}
