package com.aug.helpdesk.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.aug.helpdesk.domain.enums.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente extends Pessoal{

    /**
     *
     */
    private static final long serialVersionUID = -3392373128659906754L;

    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<Chamado>();

    public Cliente() {
        super();
        addPerfis(Perfil.CLIENTE);
    }
    
    public Cliente(BigInteger id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfis(Perfil.CLIENTE);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

}
