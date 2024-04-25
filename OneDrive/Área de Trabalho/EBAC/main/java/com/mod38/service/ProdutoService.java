package com.mod38.service;

import java.util.List;

import javax.inject.Inject;

import com.mod38.dao.IProdutoDAO;
import com.mod38.domain.Produto;
import com.mod38.service.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	private IProdutoDAO produtoDao;

	@Inject
	public ProdutoService(IProdutoDAO produtoDao) {
		super(produtoDao);
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		return produtoDao.filtrarProdutos(query);
	}

}
