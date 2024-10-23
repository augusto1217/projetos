package com.aug.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aug.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
