package com.aug.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aug.helpdesk.domain.Chamado;
import com.aug.helpdesk.repositories.ChamadoRepository;
import com.aug.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public Chamado findById(Integer id) {
        Optional<Chamado> chamado = chamadoRepository.findById(id);
        return chamado.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado! ID: " +id));
    }

    public List<Chamado> findAll() {
        return chamadoRepository.findAll();        
    }

}
