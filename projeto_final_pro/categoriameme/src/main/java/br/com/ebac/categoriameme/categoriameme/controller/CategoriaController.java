package br.com.ebac.categoriameme.categoriameme.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ebac.categoriameme.categoriameme.client.CategoriaCliente;
import br.com.ebac.categoriameme.categoriameme.entity.CategoriaMeme;
import br.com.ebac.categoriameme.categoriameme.entity.User;
import br.com.ebac.categoriameme.categoriameme.service.CategoriaServicos;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaController {

  private static final Logger logger = LoggerFactory.getLogger(CategoriaController.class);
  private final CategoriaServicos categoriaServicos;

  @Autowired
  private CategoriaCliente categoriaCliente;

  public CategoriaController(CategoriaServicos categoriaServicos){
    this.categoriaServicos = categoriaServicos;
  }

  @GetMapping("/usuarios")
  public Iterable<User> encontrarTodosUsuarios(){
    logger.info("Encontrando todos usuarios");
    Iterable<User> usuarios = categoriaCliente.FindAllThem();
    int cont = 0;
    for(@SuppressWarnings("unused") User u : usuarios){
      cont++;
    }
    logger.info("encontrarTodosUsuarios() retornou ao todo {} usuarios", cont);
    return usuarios;
  }

  @PostMapping
  public CategoriaMeme criarCategoria(@RequestBody CategoriaMeme categoriaMeme){
    logger.info("Criando categoria: {}", categoriaMeme);
    Long usuarioId = categoriaMeme.getIdUsuario();
    User usuario = categoriaCliente.FindById(usuarioId);
    if(usuario == null){
      logger.info("criarCategoria() -> usuario com ID {} nao foi encontrado", usuarioId);
      return null;
    }
    categoriaMeme.setIdUsuario(usuario.getId());
    CategoriaMeme criarCategoria = categoriaServicos.criarCategoria(categoriaMeme);
    if(criarCategoria == null){
      logger.info("criarCategoria() -> nao conseguiu criar categoriaMeme = {}", categoriaMeme);
    }
    else{
      logger.info("criarCategoria() -> criou categoriaMeme = {} com ID = {}", criarCategoria, criarCategoria.getId());
    }
    return criarCategoria;
  }

}
