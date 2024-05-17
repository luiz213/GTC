package com.gerenciador.treinamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.treinamento.entity.Colaborador;
import com.gerenciador.treinamento.repository.ColaboradorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	public List<Colaborador> getAll(){
		return getColaboradorRepository().findAll();
	}
	
	public Colaborador getById(Long id) {
		return getColaboradorRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("recurso Não encontrado"));
	}
	
	public void post(Colaborador colaborador) {
		getColaboradorRepository().save(colaborador);
	}
	
	public void delete(Long id) {
		getColaboradorRepository().deleteById(id);
	}
	
	public void update(Long id, Colaborador colaborador) {
		Colaborador colaboradorParaAtt = getColaboradorRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("recurso Não encontrado"));
		colaboradorParaAtt.setCategoria(colaborador.getCategoria());
		colaboradorParaAtt.setNome(colaborador.getNome());
		getColaboradorRepository().save(colaboradorParaAtt);
	}
	
	public ColaboradorRepository getColaboradorRepository() {
		return this.colaboradorRepository;
	}
}
