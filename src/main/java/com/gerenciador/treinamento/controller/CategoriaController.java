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
import com.gerenciador.treinamento.entity.Categoria;
import com.gerenciador.treinamento.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value="getAll")
	public ResponseEntity<List<Categoria>> getAll(){
		try {
			List<Categoria> result = getCategoriaService().getAll();
			return new ResponseEntity<>(result, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="getById/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable("id") Long id){
		try {
			Categoria result = getCategoriaService().getById(id);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="post")
	public ResponseEntity<String> post(@RequestBody Categoria categoria){
		try {
			getCategoriaService().post(categoria);
			return new ResponseEntity<>("Inserido com Sucesso!", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Não foi Possivel inserir a Categoria!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="delete/{id}") 
	public ResponseEntity<String> delete(@PathVariable("id") Long id){
		try {
			getCategoriaService().delete(id);
			return new ResponseEntity<>("Removido com Sucesso!", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Não foi Possivel Remover essa Categoria!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value="update/{id}")
	public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody Categoria categoria){
		try {
			getCategoriaService().update(id, categoria);
			return new ResponseEntity<>("Atualizado com Sucesso!", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Não foi Possivel Atualizar essa Categoria!", HttpStatus.OK);
		}
	}
	
	public CategoriaService getCategoriaService() {
		return this.categoriaService;
	}
}
