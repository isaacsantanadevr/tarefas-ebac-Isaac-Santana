package com.example.services.generic;

import java.io.Serializable;
import java.util.Collection;

import com.example.dao.Persistente;
import com.example.dao.generic.IGenericJapDAO;
import com.example.exceptions.DAOException;
import com.example.exceptions.MaisDeUmRegistroException;
import com.example.exceptions.TableException;
import com.example.exceptions.TipoChaveNaoEncontradaException;

public abstract class GenericJpaService <T extends Persistente, E extends Serializable> implements IGenericJpaService<T, E> {
	
	protected IGenericJapDAO<T, E> dao;
	
	public GenericJpaService(IGenericJapDAO<T, E> dao) {
		this.dao = dao;
	}
	

	@Override
	public T cad(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.cad(entity);
	}

	@Override
	public void remove(T entity) throws DAOException {
		this.dao.remove(entity);
	}

	@Override
	public T change(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.change(entity);
	}

	@Override
	public T find(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
		return this.dao.find(valor);
	}

	@Override
	public Collection<T> findAll() throws DAOException {
		return this.dao.findAll();
	}

}
