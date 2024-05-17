package com.gerenciador.treinamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.treinamento.entity.TreinamentoColaborador;
import com.gerenciador.treinamento.repository.TreinamentoColaboradorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TreinamentoColaboradorService {

	@Autowired
	private TreinamentoColaboradorRepository treinamentoColaboradorRepository;
	
	public List<TreinamentoColaborador> getAll(){
		return getTreinamentoColaboradorRepository().findAll();
	}
	
	public TreinamentoColaborador getById(Long id) {
		return getTreinamentoColaboradorRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("recurso Não encontrado"));
	}
	
	public void post(TreinamentoColaborador treinamentoColaborador) {
		getTreinamentoColaboradorRepository().save(treinamentoColaborador);
	}
	
	public void delete(Long id) {
		getTreinamentoColaboradorRepository().deleteById(id);
	}
	
	public void update(Long id, TreinamentoColaborador treinamentoColaborador) {
		TreinamentoColaborador treinamentoColaboradorParaAtt = getTreinamentoColaboradorRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("recurso Não encontrado"));
		treinamentoColaboradorParaAtt.setDataInicio(treinamentoColaborador.getDataInicio());
		treinamentoColaboradorParaAtt.setStatus(treinamentoColaborador.getStatus());
		treinamentoColaboradorParaAtt.setCodColaborador(treinamentoColaborador.getCodColaborador());
		treinamentoColaboradorParaAtt.setCodTreinamento(treinamentoColaborador.getCodTreinamento());
		getTreinamentoColaboradorRepository().save(treinamentoColaboradorParaAtt);
	}
	
	public TreinamentoColaboradorRepository getTreinamentoColaboradorRepository() {
		return this.treinamentoColaboradorRepository;
	}
}
