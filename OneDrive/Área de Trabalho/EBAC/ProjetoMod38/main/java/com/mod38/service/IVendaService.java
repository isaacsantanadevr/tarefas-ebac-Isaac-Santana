package com.mod38.service;

import com.mod38.dao.generic.IGenericDAO;
import com.mod38.domain.Venda;

public interface IVendaService extends IGenericDAO<Venda, Long> {

	public void finalizarVenda(Venda venda);

	public void cancelarVenda(Venda venda);

	public Venda consultarComCollection(Long id);

}
