package br.com.ebac.categoriameme.categoriameme.entity;

import java.time.LocalDate;

public class User {

  private Long id;

  private String nome;

  private String email;

  private LocalDate data;

  public User(){

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  

}
