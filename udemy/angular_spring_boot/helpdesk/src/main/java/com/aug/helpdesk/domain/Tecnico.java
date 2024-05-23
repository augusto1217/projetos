package com.aug.helpdesk.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Pessoal {

    /**
     *
     */
    private static final long serialVersionUID = -6141890872088514209L;

    private List<Chamado> chamados = new ArrayList<Chamado>();

    public Tecnico(BigInteger id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

    public Tecnico() {
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

}
