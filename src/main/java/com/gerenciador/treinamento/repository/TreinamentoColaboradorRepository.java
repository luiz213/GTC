package com.gerenciador.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.treinamento.entity.TreinamentoColaborador;

@Repository
public interface TreinamentoColaboradorRepository extends JpaRepository<TreinamentoColaborador, Long>{

}
