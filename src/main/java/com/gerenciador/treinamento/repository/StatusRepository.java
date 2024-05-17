package com.gerenciador.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.treinamento.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{

}
