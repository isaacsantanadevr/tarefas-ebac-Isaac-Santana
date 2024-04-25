package com.mod38.service;

import java.util.List;

import com.mod38.domain.Cliente;
import com.mod38.exceptions.DAOException;
import com.mod38.service.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}
