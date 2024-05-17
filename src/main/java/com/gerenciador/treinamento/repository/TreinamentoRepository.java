package com.gerenciador.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.treinamento.entity.Treinamento;

@Repository
public interface TreinamentoRepository extends JpaRepository<Treinamento, Long>{

}
