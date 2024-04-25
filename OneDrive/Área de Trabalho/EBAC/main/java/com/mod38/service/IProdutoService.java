package com.mod38.service;

import java.util.List;

import com.mod38.domain.Produto;
import com.mod38.service.generic.IGenericService;

public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
