package br.com.ebac.usuario.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.ebac.usuario.entity.Usuarios;
import br.com.ebac.usuario.repository.UsuarioRepositorio;

@Component
public class UsuarioServico {

  private final UsuarioRepositorio usuarioRepositorio;

  public UsuarioServico(UsuarioRepositorio usuarioRepositorio){
    this.usuarioRepositorio = usuarioRepositorio;
  }

  public Iterable<Usuarios> encontrarTodos(){
    return usuarioRepositorio.findAll();
  }

  public Usuarios criaUsuarios(Usuarios usuarios){
    return usuarioRepositorio.save(usuarios);
  }

  public Usuarios encontrarPorId(Long id){
    Optional<Usuarios> usop = usuarioRepositorio.findById(id);
    try {
    return usop.get(); 
    } 
    catch (NoSuchElementException e) {
    throw new RuntimeException("Usuario nao encontrado", e);
    }

  }

}
