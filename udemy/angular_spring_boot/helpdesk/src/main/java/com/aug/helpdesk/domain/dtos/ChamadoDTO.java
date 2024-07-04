package com.aug.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.aug.helpdesk.domain.Chamado;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ChamadoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    @NotNull(message = "O campo Prioridade é requerido")
    private Integer prioridade;
    @NotNull(message = "O campo Status é requerido")
    private Integer status;
    @NotNull(message = "O campo Título é requerido")
    private String titulo;
    @NotNull(message = "O campo Observações é requerido")
    private String observacoes;
    @NotNull(message = "O campo IDTécnico é requerido")    
    private Integer idTecnico;
    @NotNull(message = "O campo IDCliente é requerido")
    private Integer idCliente;
    private String nomeTecnico;
    private String nomeCliente;
    
    public ChamadoDTO() {
        super();
    }

    public ChamadoDTO(Chamado chamado) {
        super();
        this.id = chamado.getId();
        this.dataAbertura = chamado.getDataAbertura();
        this.dataFechamento = chamado.getDataFechamento();
        this.prioridade = chamado.getPrioridade().getCodigo();
        this.status = chamado.getStatus().getCodigo();
        this.titulo = chamado.getTitulo();
        this.observacoes = chamado.getObservacoes();
        this.idTecnico = chamado.getTecnico().getId();
        this.idCliente = chamado.getCliente().getId();
        this.nomeTecnico = chamado.getTecnico().getNome();
        this.nomeCliente = chamado.getCliente().getNome();
    }

    
    /** 
     * @return Integer
     */
    public Integer getId() {
        return id;
    }
    
    /** 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /** 
     * @return LocalDate
     */
    public LocalDate getDataAbertura() {
        return dataAbertura;
    }
    
    /** 
     * @param dataAbertura
     */
    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    
    /** 
     * @return LocalDate
     */
    public LocalDate getDataFechamento() {
        return dataFechamento;
    }
    
    /** 
     * @param dataFechamento
     */
    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }
    
    /** 
     * @return Integer
     */
    public Integer getPrioridade() {
        return prioridade;
    }
    
    /** 
     * @param prioridade
     */
    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }
   
    /** 
     * @return Integer
     */
    public Integer getStatus() {
        return status;
    }

    /** 
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
        
    /** 
     * @return String
     */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }   

}
