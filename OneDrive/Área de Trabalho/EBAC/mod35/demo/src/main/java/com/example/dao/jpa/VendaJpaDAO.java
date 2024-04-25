package com.example.dao.jpa;

import com.example.dao.generic.GenericJpaDAO;
import com.example.domain.jpa.ClienteJpa;
import com.example.domain.jpa.ProdutoJpa;
import com.example.domain.jpa.VendaJpa;
import com.example.exceptions.DAOException;
import com.example.exceptions.TipoChaveNaoEncontradaException;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class VendaJpaDAO extends GenericJpaDAO<VendaJpa, Long> implements IVendaJpaDAO {

	public VendaJpaDAO() {
		super(VendaJpa.class);
	}

	@Override
	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.change(venda);
	}

	@Override
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.change(venda);
	}

	@Override
	public void remove(VendaJpa entity) throws DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public VendaJpa cad(VendaJpa entity) throws TipoChaveNaoEncontradaException, DAOException {
		try {
			openConnection();
			entity.getProdutos().forEach(prod -> {
				ProdutoJpa prodJpa = em.merge(prod.getProduto());
				prod.setProduto(prodJpa);
			});
			ClienteJpa cliente = em.merge(entity.getCliente());
			entity.setCliente(cliente);
			em.persist(entity);
			em.getTransaction().commit();
			closeConnection();
			return entity;
		} catch (Exception e) {
			throw new DAOException("ERRO SALVANDO VENDA ", e);
		}
		
	}

	@Override
	public VendaJpa consultarComCollection(Long id) {
		openConnection();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<VendaJpa> query = builder.createQuery(VendaJpa.class);
		Root<VendaJpa> root = query.from(VendaJpa.class);
		root.fetch("cliente");
		root.fetch("produtos");
		query.select(root).where(builder.equal(root.get("id"), id));
		TypedQuery<VendaJpa> tpQuery = em.createQuery(query);
		VendaJpa venda = tpQuery.getSingleResult();   
		closeConnection();
		return venda;
	}
	

}
