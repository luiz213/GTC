package com.gerenciador.treinamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.treinamento.entity.Categoria;
import com.gerenciador.treinamento.repository.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAll() {
		return getCategoriaRepository().findAll();
	}
	
	public Categoria getById(Long id) {
		return getCategoriaRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("recurso não encontrado"));
	}
	
	public void post(Categoria categoria) {
		getCategoriaRepository().save(categoria);
	}
	
	public void delete(Long id) {
		getCategoriaRepository().deleteById(id);
	}
	
	public void update(Long id, Categoria categoria) {
		Categoria categoriaParaAtt = getCategoriaRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("recurso não encontrado"));
		categoriaParaAtt.setDescricao(categoria.getDescricao());
		getCategoriaRepository().save(categoria);
	}
	
	public CategoriaRepository getCategoriaRepository() {
		return this.categoriaRepository;
	}
}
