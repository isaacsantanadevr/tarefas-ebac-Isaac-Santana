package br.com.ebac.meme.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Meme{

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memes_sequencia")
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "nome", nullable = false)
  private String nome;

  @Column(name = "descricao", nullable = false)
  private String descricao;

  @Column(name = "cadastro", nullable = false)
  private Date dataCadastro;

  @Column(name = "url", nullable = false)
  private String url;

  @Column(name = "usuario_id", nullable = false)
  private Long usuarioId;

  @Column(name = "categoria_meme_id", nullable = false)
  private Long categoriaMemeId;

  public Meme(){

  }

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

  public Date getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(Date dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Long getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(Long usuarioId) {
    this.usuarioId = usuarioId;
  }

  public Long getCategoriaMemeId() {
    return categoriaMemeId;
  }

  public void setCategoriaMemeId(Long categoriaMemeId) {
    this.categoriaMemeId = categoriaMemeId;
  }

  
}