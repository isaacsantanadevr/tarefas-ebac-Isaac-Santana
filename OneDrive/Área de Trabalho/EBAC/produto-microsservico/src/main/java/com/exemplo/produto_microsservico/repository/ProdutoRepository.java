package com.exemplo.produto_microsservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.produto_microsservico.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}