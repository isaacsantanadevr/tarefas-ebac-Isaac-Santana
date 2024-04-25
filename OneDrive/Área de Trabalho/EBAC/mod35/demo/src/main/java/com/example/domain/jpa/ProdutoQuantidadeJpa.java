package com.example.domain.jpa;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUTO_QUANT")
public class ProdutoQuantidadeJpa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prod_qtd_seq")
	@SequenceGenerator(name="prod_qtd_seq", sequenceName="sq_prod_qtd", initialValue = 1, allocationSize = 1)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private ProdutoJpa prod;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quant;
	
	@Column(name = "valor_total", nullable = false)
	private BigDecimal tot;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_venda_fk", 
		foreignKey = @ForeignKey(name = "fk_prod_qtd_venda"), 
		referencedColumnName = "id", nullable = false
	)
	private VendaJpa venda;
	
	public ProdutoQuantidadeJpa() {
		this.quant = 0;
		this.tot = BigDecimal.ZERO;
	}

	public ProdutoJpa getProduto() {
		return prod;
	}

	public void setProduto(ProdutoJpa prod) {
		this.prod = prod;
	}

	public Integer getQuantidade() {
		return quant;
	}

	public void setQuantidade(Integer quant) {
		this.quant = quant;
	}

	public BigDecimal getValorTotal() {
		return tot;
	}

	public void setValorTotal(BigDecimal tot) {
		this.tot = tot;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public VendaJpa getVenda() {
		return venda;
	}

	public void setVenda(VendaJpa venda) {
		this.venda = venda;
	}

	public void add(Integer quantidade) {
		this.quant += quantidade;
		BigDecimal novoValor = this.prod.getValor().multiply(BigDecimal.valueOf(quantidade));
		BigDecimal novoTotal = this.tot.add(novoValor);
		this.tot = novoTotal;
	}
	
	public void remove(Integer quantidade) {
		this.quant -= quantidade;
		BigDecimal novoValor = this.prod.getValor().multiply(BigDecimal.valueOf(quantidade));
		this.tot = this.tot.subtract(novoValor);
	}
    
}
