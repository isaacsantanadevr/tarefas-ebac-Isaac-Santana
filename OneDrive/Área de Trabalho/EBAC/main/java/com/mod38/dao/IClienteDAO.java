package com.mod38.dao;

import java.util.List;

import com.mod38.dao.generic.IGenericDAO;
import com.mod38.domain.Cliente;

public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

	List<Cliente> filtrarClientes(String query);

}
