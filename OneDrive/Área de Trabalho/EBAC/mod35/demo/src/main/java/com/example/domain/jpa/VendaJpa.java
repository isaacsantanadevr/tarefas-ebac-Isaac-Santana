package com.example.domain.jpa;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.example.dao.Persistente;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "VENDA")
public class VendaJpa implements Persistente {

    public enum Status {
		INICIADA, CONCLUIDA, CANCELADA;

		public static Status getByName(String value) {
			for (Status status : Status.values()) {
	            if (status.name().equals(value)) {
	                return status;
	            }
	        }
			return null;
		}
	}

    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="venda_seq")
	@SequenceGenerator(name="venda_seq", sequenceName="sq_venda", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "CODIGO", nullable = false, unique = true)
	private String codigo;

	@ManyToOne
	@JoinColumn(name = "id_cliente_fk", 
		foreignKey = @ForeignKey(name = "fk_venda_cliente"), 
		referencedColumnName = "id", nullable = false
	)
	private ClienteJpa cliente;

    /*
	 * OBS: Não é uma boa prática utiliar FetchType.EAGER pois ele sempre irá trazer todos os objetos da collection
	 * mesmo sem precisar utilizar. Fazer um método específico para buscar tudo e utilizar quando precisar
	 * 
	 * @see IVendaJpaDAO consultarComCollection
	 */
	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL/*, fetch = FetchType.EAGER*/)
	private Set<ProdutoQuantidadeJpa> produtos;
	
	@Column(name = "TOTAL", nullable = false)
	private BigDecimal tot;
	
	@Column(name = "DATA_VENDA", nullable = false)
	private Instant dataVenda;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS_VENDA", nullable = false)
	private Status status;
	
	public VendaJpa() {
		produtos = new HashSet<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ClienteJpa getCliente() {
		return cliente;
	}

	public void setCliente(ClienteJpa cliente) {
		this.cliente = cliente;
	}

	public Set<ProdutoQuantidadeJpa> getProdutos() {
		return produtos;
	}

	public void adicionarProduto(ProdutoJpa produto, Integer quantidade) {
		validarStatus();
		Optional<ProdutoQuantidadeJpa> op = 
				produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
		if (op.isPresent()) {
			ProdutoQuantidadeJpa produtpQtd = op.get();
			produtpQtd.add(quantidade);
		} else {
			// Criar fabrica para criar ProdutoQuantidade
			ProdutoQuantidadeJpa prod = new ProdutoQuantidadeJpa();
			prod.setVenda(this);
			prod.setProduto(produto);
			prod.add(quantidade);
			produtos.add(prod);
		}
		recalcularValorTotalVenda();
	}

	private void validarStatus() {
		if (this.status == Status.CONCLUIDA) {
			throw new UnsupportedOperationException("IMPOSSÍVEL ALTERAR VENDA FINALIZADA");
		}
	}
	
	public void removerProduto(ProdutoJpa produto, Integer quantidade) {
		validarStatus();
		Optional<ProdutoQuantidadeJpa> op = 
				produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
		
		if (op.isPresent()) {
			ProdutoQuantidadeJpa produtpQtd = op.get();
			if (produtpQtd.getQuantidade()>quantidade) {
				produtpQtd.remove(quantidade);
				recalcularValorTotalVenda();
			} else {
				produtos.remove(op.get());
				recalcularValorTotalVenda();
			}
			
		}
	}
	
	public void removerTodosProdutos() {
		validarStatus();
		produtos.clear();
		tot = BigDecimal.ZERO;
	}
	
	public Integer getQuantidadeTotalProdutos() {
		// Soma a quantidade getQuantidade() de todos os objetos ProdutoQuantidade
		int result = produtos.stream()
		  .reduce(0, (partialCountResult, prod) -> partialCountResult + prod.getQuantidade(), Integer::sum);
		return result;
	}
	
	public void recalcularValorTotalVenda() {
		//validarStatus();
		BigDecimal valorTotal = BigDecimal.ZERO;
		for (ProdutoQuantidadeJpa prod : this.produtos) {
			valorTotal = valorTotal.add(prod.getValorTotal());
		}
		this.tot = valorTotal;
	}

	public BigDecimal getValorTotal() {
		return tot;
	}

	public Instant getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Instant dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setValorTotal(BigDecimal tot) {
		this.tot = tot;
	}

	public void setProdutos(Set<ProdutoQuantidadeJpa> produtos) {
		this.produtos = produtos;
	}
    
}
