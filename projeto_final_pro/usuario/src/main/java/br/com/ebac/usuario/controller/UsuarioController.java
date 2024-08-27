package br.com.ebac.usuario.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ebac.usuario.entity.Usuarios;
import br.com.ebac.usuario.service.UsuarioServico;

@RestController
@RequestMapping("/users")
public class UsuarioController {

  private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

  private final UsuarioServico usuarioServico;


  public UsuarioController(UsuarioServico usuarioServico){
    this.usuarioServico = usuarioServico;
  }

  @PostMapping
  public Usuarios criarUsuarios(@RequestBody Usuarios usuarios){
    logger.info("Criando usuario: {}", usuarios);
    Usuarios usuario_novo = usuarioServico.criaUsuarios(usuarios);
    logger.info("Novo usuario criado: {}", usuario_novo);
    return usuario_novo;
  }

  @GetMapping
  public Iterable<Usuarios> encontrarTodos(){
    logger.info("Encontrando usuarios");
    Iterable<Usuarios> usuarios = usuarioServico.encontrarTodos();
    logger.info("Encontrados {} usuarios", usuarios.spliterator().getExactSizeIfKnown());
    return usuarios;
  }

  @GetMapping("/{id}")
  public Usuarios encontrarPorId(@PathVariable Long id){
    logger.info("Procurar usuario com ID {}", id);
    Usuarios usuario = usuarioServico.encontrarPorId(id);
    logger.info("Usuario encontrado: {}", usuario);
    return usuario;
  }

}
