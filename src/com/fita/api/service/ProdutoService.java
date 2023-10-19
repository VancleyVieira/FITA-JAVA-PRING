package com.fita.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fita.api.model.Produto;
import com.fita.api.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Optional<Produto> getById(long id) {
		return produtoRepository.findById(id);
	}
	
	public void deletar(long id) {
		produtoRepository.deleteById(id);
	}
	

}
