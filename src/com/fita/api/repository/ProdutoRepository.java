package com.fita.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fita.api.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
	public List<Produto> findAll();

}
