package com.mod38.dao;

import com.mod38.dao.generic.IGenericDAO;
import com.mod38.domain.Venda;

public interface IVendaDAO extends IGenericDAO<Venda, Long> {

	void finalizarVenda(Venda venda);

	void cancelarVenda(Venda venda);

	Venda consultarComCollection(Long id);

}
