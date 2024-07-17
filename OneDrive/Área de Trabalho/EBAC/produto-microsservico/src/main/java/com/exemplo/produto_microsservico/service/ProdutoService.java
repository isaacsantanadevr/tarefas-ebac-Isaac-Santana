package com.exemplo.produto_microsservico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.exemplo.produto_microsservico.model.Produto;
import com.exemplo.produto_microsservico.repository.ProdutoRepository;

@Service
public class ProdutoService{
  
  private ProdutoRepository produtoRepository;

      public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

}