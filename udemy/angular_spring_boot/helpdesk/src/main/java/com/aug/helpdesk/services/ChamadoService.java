package com.aug.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aug.helpdesk.domain.Chamado;
import com.aug.helpdesk.domain.Cliente;
import com.aug.helpdesk.domain.Tecnico;
import com.aug.helpdesk.domain.dtos.ChamadoDTO;
import com.aug.helpdesk.domain.enums.Prioridade;
import com.aug.helpdesk.domain.enums.Status;
import com.aug.helpdesk.repositories.ChamadoRepository;
import com.aug.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private ClienteService clienteService;

    public Chamado findById(Integer id) {
        Optional<Chamado> chamado = chamadoRepository.findById(id);
        return chamado.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado! ID: " +id));
    }

    public List<Chamado> findAll() {
        return chamadoRepository.findAll();        
    }

    public Chamado create(@Valid ChamadoDTO dto) {
       return chamadoRepository.save(newChamado(dto));
    }

    public Chamado update(Integer id, @Valid ChamadoDTO dto) {
        dto.setId(id);
        Chamado oldChamado = findById(id);
        oldChamado = newChamado(dto);
        return chamadoRepository.save(oldChamado);
     }

    private Chamado newChamado(ChamadoDTO dto) {
        Tecnico tecnico = tecnicoService.findById(dto.getIdTecnico());
        Cliente cliente = clienteService.findById(dto.getIdCliente());

        Chamado chamado = new Chamado();

        if(dto.getId() != null) {
            chamado.setId(dto.getId());
        }

        if(dto.getStatus().equals(Status.ENCERRADO.getCodigo())) {
            chamado.setDataFechamento(LocalDate.now());
        }

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(dto.getPrioridade()));
        chamado.setStatus(Status.toEnum(dto.getStatus()));
        chamado.setTitulo(dto.getTitulo());
        chamado.setObservacoes(dto.getObservacoes());

        return chamado;

    }   

}
