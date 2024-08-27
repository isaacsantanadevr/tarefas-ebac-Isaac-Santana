package br.com.ebac.meme.entity;

import java.sql.Date;

public class CategoriaMeme {

  private Long id;

  private String nome;

  private String descricao;

  private Date cadastro;

  public CategoriaMeme(Long id, String nome, String descricao, Date cadastro){
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.cadastro = cadastro;
  }

  public CategoriaMeme(){
    
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

  public Date getCadastro() {
    return cadastro;
  }

  public void setCadastro(Date cadastro) {
    this.cadastro = cadastro;
  }

}
