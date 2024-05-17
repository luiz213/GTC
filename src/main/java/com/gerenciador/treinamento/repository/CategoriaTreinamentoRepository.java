package com.gerenciador.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.treinamento.entity.CategoriaTreinamento;

@Repository
public interface CategoriaTreinamentoRepository extends JpaRepository<CategoriaTreinamento, Long>{

}
