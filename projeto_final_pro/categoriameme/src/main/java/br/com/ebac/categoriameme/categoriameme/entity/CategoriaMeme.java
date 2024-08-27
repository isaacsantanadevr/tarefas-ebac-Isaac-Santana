package br.com.ebac.categoriameme.categoriameme.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CategoriaMeme {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_categorias")
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "nome", nullable = false)
  private String nome;

  @Column(name = "descricao", nullable = false)
  private String descricao;

  @Column(name = "data_registro", nullable = false)
  private LocalDate dataRegistro;

  @Column(name = "id_usuario", nullable = false)
  private Long idUsuario;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public LocalDate getDataRegistro() {
    return dataRegistro;
  }

  public void setDataRegistro(LocalDate dataRegistro) {
    this.dataRegistro = dataRegistro;
  }

  public Long getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Long idUsuario) {
    this.idUsuario = idUsuario;
  }

  


}
