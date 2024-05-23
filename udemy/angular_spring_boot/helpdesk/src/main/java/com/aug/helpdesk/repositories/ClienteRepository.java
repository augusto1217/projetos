package com.aug.helpdesk.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aug.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, BigInteger> {

}
