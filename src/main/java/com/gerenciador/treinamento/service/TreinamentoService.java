package com.gerenciador.treinamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.treinamento.entity.Treinamento;
import com.gerenciador.treinamento.repository.TreinamentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TreinamentoService {

	@Autowired
	private TreinamentoRepository treinamentoRepository;
	
	public List<Treinamento> getAll(){
		return getTreinamentoRepository().findAll();
	}
	
	public Treinamento getById(Long id) {
		return getTreinamentoRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("recurso Não encontrado"));
	}
	
	public void post(Treinamento treinamento) {
		getTreinamentoRepository().save(treinamento);
	}
	
	public void delete(Long id) {
		getTreinamentoRepository().deleteById(id);
	}
	
	public void update(Long id, Treinamento treinamento) {
		Treinamento treinamentoParaAtt = getTreinamentoRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("recurso Não encontrado"));
		treinamentoParaAtt.setCategoria(treinamento.getCategoria());
		treinamentoParaAtt.setDataCadastro(treinamento.getDataCadastro());
		treinamentoParaAtt.setDescricao(treinamento.getDescricao());
		treinamentoParaAtt.setDuracao(treinamento.getDuracao());
		treinamentoParaAtt.setNome(treinamento.getNome());
		getTreinamentoRepository().save(treinamentoParaAtt);
	}
	
	public TreinamentoRepository getTreinamentoRepository() {
		return this.treinamentoRepository;
	}
}
