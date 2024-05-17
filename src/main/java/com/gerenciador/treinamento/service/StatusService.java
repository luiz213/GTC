package com.gerenciador.treinamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.treinamento.entity.Status;
import com.gerenciador.treinamento.repository.StatusRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StatusService {

	@Autowired
	private StatusRepository statusRepository;
	
	public List<Status> getAll(){
		return getStatusRepository().findAll();
	}
	
	public Status getById(Long id) {
		return getStatusRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("recurso Não encontrado"));
	}
	
	public void post(Status status) {
		getStatusRepository().save(status);
	}
	
	public void delete(Long id) {
		getStatusRepository().deleteById(id);
	}
	
	public void update(Long id, Status status) {
		Status StatusParaAtt = getStatusRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("recurso Não encontrado"));
		StatusParaAtt.setDescricao(status.getDescricao());
		getStatusRepository().save(StatusParaAtt);
	}
	
	public StatusRepository getStatusRepository() {
		return this.statusRepository;
	}
}
