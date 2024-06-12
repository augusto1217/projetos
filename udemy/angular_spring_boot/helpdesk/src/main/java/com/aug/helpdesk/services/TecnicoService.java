package com.aug.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aug.helpdesk.domain.Pessoa;
import com.aug.helpdesk.domain.Tecnico;
import com.aug.helpdesk.domain.dtos.TecnicoDTO;
import com.aug.helpdesk.repositories.PessoaRepository;
import com.aug.helpdesk.repositories.TecnicoRepository;
import com.aug.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.aug.helpdesk.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
        return tecnico.orElseThrow(() -> new ObjectNotFoundException("Id: " + id + " não encontrado!!!"));
    }

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico save(TecnicoDTO tec) {
        tec.setId(null);
        validarPorCpfEmail(tec);
        Tecnico newTec = new Tecnico(tec);
        return tecnicoRepository.save(newTec);
    }

    public Tecnico update(Integer id, @Valid TecnicoDTO tecnicoDTO) {
        tecnicoDTO.setId(id);
        Tecnico tecnico = findById(id);
        validarPorCpfEmail(tecnicoDTO);
        tecnico = new Tecnico(tecnicoDTO);
        return tecnicoRepository.save(tecnico);
    }

    private void validarPorCpfEmail(TecnicoDTO tec) {
        
        Optional<Pessoa> p = pessoaRepository.findByCpf(tec.getCpf());        
        if(p.isPresent() && p.get().getId() != tec.getId()) {
            throw new DataIntegrityViolationException("Cpf já cadastrado no sistema!!!");
        }

        p = pessoaRepository.findByEmail(tec.getEmail());
        if(p.isPresent() && p.get().getId() != tec.getId()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!!!");
        }
    }

}
