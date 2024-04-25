package com.mod38.dao;

import java.util.List;

import com.mod38.dao.generic.IGenericDAO;
import com.mod38.domain.Produto;

public interface IProdutoDAO extends IGenericDAO<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
