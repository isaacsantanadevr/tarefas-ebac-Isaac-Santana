package br.com.ebac.animal_service.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Animal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(nullable = false)
  private String nomeProvisorio;

  @Column(nullable = false)
  private Integer idadeEstimada;

  @Column(nullable = false)
  private String especie;

  @Column(nullable = false)
  private String raca;

  @Column(nullable = false)
  private Date dataEntrada;

  @Column
  private Date dataAdocao;

  @Column(nullable = false)
  private String condicoesChegada;

  @Column(nullable = false)
  private String nomeRecebedor;

  @Column
  private Date dataObito;

  @Column(nullable = false)
  private String porte;

  // Getters e Setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNomeProvisorio() {
    return nomeProvisorio;
  }

  public void setNomeProvisorio(String nomeProvisorio) {
    this.nomeProvisorio = nomeProvisorio;
  }

  public Integer getIdadeEstimada() {
    return idadeEstimada;
  }

  public void setIdadeEstimada(Integer idadeEstimada) {
    this.idadeEstimada = idadeEstimada;
  }

  public String getEspecie() {
    return especie;
  }

  public void setEspecie(String especie) {
    this.especie = especie;
  }

  public String getRaca() {
    return raca;
  }

  public void setRaca(String raca) {
    this.raca = raca;
  }

  public Date getDataEntrada() {
    return dataEntrada;
  }

  public void setDataEntrada(Date dataEntrada) {
    this.dataEntrada = dataEntrada;
  }

  public Date getDataAdocao() {
    return dataAdocao;
  }

  public void setDataAdocao(Date dataAdocao) {
    this.dataAdocao = dataAdocao;
  }

  public String getCondicoesChegada() {
    return condicoesChegada;
  }

  public void setCondicoesChegada(String condicoesChegada) {
    this.condicoesChegada = condicoesChegada;
  }

  public String getNomeRecebedor() {
    return nomeRecebedor;
  }

  public void setNomeRecebedor(String nomeRecebedor) {
    this.nomeRecebedor = nomeRecebedor;
  }

  public Date getDataObito() {
    return dataObito;
  }

  public void setDataObito(Date dataObito) {
    this.dataObito = dataObito;
  }

  public String getPorte() {
    return porte;
  }

  public void setPorte(String porte) {
    this.porte = porte;
  }
}
