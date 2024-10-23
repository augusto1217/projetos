package com.aug.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aug.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
