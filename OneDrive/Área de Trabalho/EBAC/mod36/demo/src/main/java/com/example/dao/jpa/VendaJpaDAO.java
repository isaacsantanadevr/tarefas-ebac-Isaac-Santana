package com.example.dao.jpa;

//import com.example.dao.generic.GenericJpaDAO;
import com.example.dao.generic.GenericJpaDB1DAO;
import com.example.domain.jpa.ClienteJpa;
import com.example.domain.jpa.ProdutoJpa;
import com.example.domain.jpa.VendaJpa;
import com.example.exceptions.DAOException;
import com.example.exceptions.TipoChaveNaoEncontradaException;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class VendaJpaDAO extends GenericJpaDB1DAO<VendaJpa, Long> implements IVendaJpaDAO {

	public VendaJpaDAO() {
		super(VendaJpa.class);
	}

	@Override
	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.alterar(venda);
	}

	@Override
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.alterar(venda);
	}

	@Override
	public void excluir(VendaJpa entity) throws DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public VendaJpa cadastrar(VendaJpa entity) throws TipoChaveNaoEncontradaException, DAOException {
		try {
			openConnection();
			entity.getProdutos().forEach(prod -> {
				ProdutoJpa prodJpa = entityManager.merge(prod.getProduto());
				prod.setProduto(prodJpa);
			});
			ClienteJpa cliente = entityManager.merge(entity.getCliente());
			entity.setCliente(cliente);
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			closeConnection();
			return entity;
		} catch (Exception e) {
			throw new DAOException("ERRO SALVANDO VENDA ", e);
		}
		
	}

	@Override
	public VendaJpa consultarComCollection(Long id) {
		openConnection();
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VendaJpa> query = builder.createQuery(VendaJpa.class);
		Root<VendaJpa> root = query.from(VendaJpa.class);
		root.fetch("cliente");
		root.fetch("produtos");
		query.select(root).where(builder.equal(root.get("id"), id));
		TypedQuery<VendaJpa> tpQuery = 
				entityManager.createQuery(query);
		VendaJpa venda = tpQuery.getSingleResult();   
		closeConnection();
		return venda;
	}
	

}
