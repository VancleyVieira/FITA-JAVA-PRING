package com.fita.api.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fita.api.model.Produto;
import com.fita.api.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoRestController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	@ResponseBody
	public List<Produto> listar() {
		return produtoService.listar();
		
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
		return new ResponseEntity<Produto>(produtoService.salvar(produto), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	@ResponseBody
	public ResponseEntity<Produto> alterar(@RequestBody Produto produto, @PathVariable("id") long id) {
		Optional<Produto> optionalProduto = produtoService.getById(id);
		if(optionalProduto.isPresent()) {
			return new ResponseEntity<Produto>(produtoService.salvar(produto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("{id}")
	@ResponseBody
	public ResponseEntity<Produto> deletar(@PathVariable("id") long id) {
		Optional<Produto> optionalProduto = produtoService.getById(id);
		if(optionalProduto.isPresent()) {
			produtoService.deletar(id);
			return new ResponseEntity<Produto>(optionalProduto.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
