package com.mod38.service;

import java.util.List;

import javax.inject.Inject;

import com.mod38.dao.IClienteDAO;
import com.mod38.domain.Cliente;
import com.mod38.exceptions.DAOException;
import com.mod38.exceptions.MaisDeUmRegistroException;
import com.mod38.exceptions.TableException;
import com.mod38.service.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

	private IClienteDAO clienteDAO;

	@Inject
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		this.clienteDAO = clienteDAO;
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cliente> filtrarClientes(String query) {
		return clienteDAO.filtrarClientes(query);
	}

}
