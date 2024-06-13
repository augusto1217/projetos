package com.aug.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aug.helpdesk.domain.Cliente;
import com.aug.helpdesk.domain.Pessoa;
import com.aug.helpdesk.domain.dtos.ClienteDTO;
import com.aug.helpdesk.repositories.ClienteRepository;
import com.aug.helpdesk.repositories.PessoaRepository;
import com.aug.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.aug.helpdesk.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Id: " + id + " não encontrado!!!"));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente save(ClienteDTO clienteDto) {
        clienteDto.setId(null);
        validarPorCpfEmail(clienteDto);
        Cliente cliente = new Cliente(clienteDto);
        return clienteRepository.save(cliente);
    }

    public Cliente update(Integer id, @Valid ClienteDTO clienteDTO) {
        clienteDTO.setId(id);
        Cliente cliente = findById(id);
        validarPorCpfEmail(clienteDTO);
        cliente = new Cliente(clienteDTO);
        return clienteRepository.save(cliente);
    }

    public void delete(Integer id) {
        Cliente cliente = findById(id);
        if(cliente.getChamados().size() > 0) {
            throw new DataIntegrityViolationException("Cliente possuí ordem de serviço(s) vinculado(s) e não pode ser excluído");            
        }
        clienteRepository.delete(cliente);
    }

    private void validarPorCpfEmail(ClienteDTO cli) {
        Optional<Pessoa> p = pessoaRepository.findByCpf(cli.getCpf());
        if(p.isPresent() && p.get().getId() != cli.getId()) {
            throw new DataIntegrityViolationException("Cpf já cadastrado no sistema!!!");
        }

        p = pessoaRepository.findByEmail(cli.getEmail());
        if(p.isPresent() && p.get().getId() != cli.getId()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!!!");
        }
    }

}
