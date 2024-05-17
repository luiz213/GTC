package com.gerenciador.treinamento.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TREINAMENTO_COLABORADOR")
public class TreinamentoColaborador {

    @Id
    @Column(name = "COD_TREINAMENTO")
    private Long codTreinamento;

    @Column(name = "COD_COLABORADOR")
    private Long codColaborador;

    @Column(name = "DATA_INICIO")
    private Date dataInicio;

    @ManyToOne
    @JoinColumn(name = "ID_STATUS")
    private Status status;

	public Long getCodTreinamento() {
		return codTreinamento;
	}

	public void setCodTreinamento(Long codTreinamento) {
		this.codTreinamento = codTreinamento;
	}

	public Long getCodColaborador() {
		return codColaborador;
	}

	public void setCodColaborador(Long codColaborador) {
		this.codColaborador = codColaborador;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

    
}
