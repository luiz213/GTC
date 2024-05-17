package com.gerenciador.treinamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.treinamento.entity.CategoriaTreinamento;
import com.gerenciador.treinamento.repository.CategoriaTreinamentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaTreinamentoService {

	@Autowired
	private CategoriaTreinamentoRepository categoriaTreinamentoRepository;
	
	public List<CategoriaTreinamento> getAll(){
		return getCategoriaTreinamentorepository().findAll();
	}
	
	public CategoriaTreinamento getById(Long id) {
		return getCategoriaTreinamentorepository().findById(id).orElseThrow(() -> new EntityNotFoundException("recurso não encontrado"));
	}
	
	public void post(CategoriaTreinamento categoriaTreinamento) {
		getCategoriaTreinamentorepository().save(categoriaTreinamento);
	}
	
	public void delete(Long id) {
		getCategoriaTreinamentorepository().deleteById(id);
	}
	
	public void update(Long id, CategoriaTreinamento categoriaTreinamento) {
		CategoriaTreinamento categoriaTreinamentoParaAtt = getCategoriaTreinamentorepository().findById(id).orElseThrow(() -> new EntityNotFoundException("recurso não encontrado"));
		categoriaTreinamentoParaAtt.setTreinamento(categoriaTreinamento.getTreinamento());
		getCategoriaTreinamentorepository().save(categoriaTreinamentoParaAtt);
	}
	
	public CategoriaTreinamentoRepository getCategoriaTreinamentorepository() {
		return this.categoriaTreinamentoRepository;
	}
}
