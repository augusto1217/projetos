package com.aug.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.aug.helpdesk.domain.dtos.TecnicoDTO;
import com.aug.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tecnico extends Pessoa {

    /**
     *
     */
    private static final long serialVersionUID = -6141890872088514209L;

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<Chamado>();

    public Tecnico() {
        super();
        addPerfis(Perfil.CLIENTE);
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfis(Perfil.CLIENTE);
    }

    public Tecnico(TecnicoDTO tecnicoDto) {
        super();
        this.id = tecnicoDto.getId();
        this.nome = tecnicoDto.getNome();
        this.cpf = tecnicoDto.getCpf();
        this.email = tecnicoDto.getEmail();
        this.senha = tecnicoDto.getSenha();
        this.perfis = tecnicoDto.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = tecnicoDto.getDataCriacao();
        addPerfis(Perfil.CLIENTE);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

}
