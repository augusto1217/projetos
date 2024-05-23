package com.aug.helpdesk.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.aug.helpdesk.domain.enums.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Tecnico extends Pessoal {

    /**
     *
     */
    private static final long serialVersionUID = -6141890872088514209L;

    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<Chamado>();

    public Tecnico() {
        super();
        addPerfis(Perfil.TECNICO);
    }

    public Tecnico(BigInteger id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfis(Perfil.TECNICO);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

}