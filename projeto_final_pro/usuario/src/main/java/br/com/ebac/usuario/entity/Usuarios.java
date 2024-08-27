package br.com.ebac.usuario.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuarios {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_usuario")
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "nome", nullable = false)
  private String nome;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "registro", nullable = false)
  private LocalDate registro;

  public Usuarios(){

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

  public LocalDate getRegistro() {
    return registro;
  }

  public void setRegistro(LocalDate registro) {
    this.registro = registro;
  }

  

}
