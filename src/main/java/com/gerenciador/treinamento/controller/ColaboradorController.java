package com.gerenciador.treinamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.treinamento.entity.Colaborador;
import com.gerenciador.treinamento.service.ColaboradorService;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

	@Autowired
	private ColaboradorService colaboradorService;
	
	@GetMapping(value="getAll")
	public ResponseEntity<List<Colaborador>> getAll(){
		try {
			List<Colaborador> result = getColaboradorService().getAll();
			return new ResponseEntity<>(result, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="getById/{id}")
	public ResponseEntity<Colaborador> getById(@PathVariable("id") Long id){
		try {
			Colaborador result = getColaboradorService().getById(id);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="post")
	public ResponseEntity<String> post(@RequestBody Colaborador colaborador){
		try {
			getColaboradorService().post(colaborador);
			return new ResponseEntity<>("Colaborador Cadastrado com sucesso!", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Não foi Possivel cadastrar o Colaborador!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id){
		try {
			getColaboradorService().delete(id);
			return new ResponseEntity<>("Colaborador Removido com Sucesso!", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Não foi possivel remover esse Colaborador!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value="update/{id}")
	public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody Colaborador colaborador){
		try {
			getColaboradorService().update(id, colaborador);
			return new ResponseEntity<>("Colaborador Atualizado com Sucesso!", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Não foi Possivel Atualizar o Colaborador!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ColaboradorService getColaboradorService() {
		return this.colaboradorService;
	}
}
