package com.aug.helpdesk.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoal{

    /**
     *
     */
    private static final long serialVersionUID = -3392373128659906754L;

    private List<Chamado> chamados = new ArrayList<Chamado>();

    public Cliente(BigInteger id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

    public Cliente() {
        super();
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

}
