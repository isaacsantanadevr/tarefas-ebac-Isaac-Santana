package com.example.dao.generic;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.example.dao.Persistente;
import com.example.exceptions.DAOException;
import com.example.exceptions.MaisDeUmRegistroException;
import com.example.exceptions.TableException;
import com.example.exceptions.TipoChaveNaoEncontradaException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GenericJpaDAO <T extends Persistente, E extends Serializable> implements IGenericJapDAO <T,E> {

    protected EntityManagerFactory emf;
	
	protected EntityManager em;
	
	private Class<T> persistenteClass;
	
	public GenericJpaDAO(Class<T> persistenteClass) {
		this.persistenteClass = persistenteClass;
	}
	
	@Override
	public T cad(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		openConnection();
		em.persist(entity);
		em.getTransaction().commit();
		closeConnection();
		return entity;
	}

	@Override
	public void remove(T entity) throws DAOException {
		openConnection();
		entity = em.merge(entity);
		em.remove(entity);
		em.getTransaction().commit();
		closeConnection();
	}

	@Override
	public T change(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		openConnection();
		entity = em.merge(entity);
		em.getTransaction().commit();
		closeConnection();
		return entity;
	}

	@Override
	public T find(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
		openConnection();
		T entity = em.find(this.persistenteClass, valor);
		em.getTransaction().commit();
		closeConnection();
		return entity;
	}

	@Override
	public Collection<T> findAll() throws DAOException {
		openConnection();
		List<T> list = em.createQuery(getSelectSql(), this.persistenteClass).getResultList();
		closeConnection();
		return list;
	}
	
	protected void openConnection() {
		emf = Persistence.createEntityManagerFactory("Projeto4");
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}
	
	protected void closeConnection() {
		em.close();
		emf.close();
	}
	
	private String getSelectSql() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT obj FROM ");
		sb.append(this.persistenteClass.getSimpleName());
		sb.append(" obj");
		return sb.toString();
	}
    
}
