package com.gerenciador.treinamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORIA_TREINAMENTO")
public class CategoriaTreinamento {

    @Id
    @Column(name = "ID_CATEGORIA")
    private Long idCategoria;

    @ManyToOne
    @JoinColumn(name = "ID_TREINAMENTO")
    private Treinamento treinamento;

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Treinamento getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Treinamento treinamento) {
		this.treinamento = treinamento;
	}

    
}
