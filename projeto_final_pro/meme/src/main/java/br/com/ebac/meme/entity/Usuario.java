package br.com.ebac.meme.entity;

import java.sql.Date;

public class Usuario {
  
  private Long Id;

  private String nome;

  private String email;

  private Date cadastro;

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getCadastro() {
    return cadastro;
  }

  public void setCadastro(Date cadastro) {
    this.cadastro = cadastro;
  }

}
