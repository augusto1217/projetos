package com.aug.helpdesk.domain.enums;

public enum Status {
    
    ABERTO(0, "ROLE_ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

    private Integer codigo;
    private String descricao;
    
    private Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status toEnum(Integer cod) throws IllegalAccessException {
        
        if(cod == null) {
            return null;
        }

        for (Status s : Status.values()) {
            if(cod.equals(s.getCodigo())) {
                return s;
            }
        }

        throw new IllegalAccessException("Status Inválido");

    }
    
}
