package br.com.ebac.categoriameme.categoriameme.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ebac.categoriameme.categoriameme.entity.CategoriaMeme;
import br.com.ebac.categoriameme.categoriameme.repository.CategoriaRepositorio;

@Component
public class CategoriaServicos {
  @Autowired
  private final CategoriaRepositorio categoriaRepositorio;

  public CategoriaServicos(CategoriaRepositorio categoriaRepositorio){
    this.categoriaRepositorio = categoriaRepositorio;
  }

  public Iterable<CategoriaMeme> encontrarTodasCategorias(){
    return categoriaRepositorio.findAll();
  }

  public CategoriaMeme criarCategoria(CategoriaMeme categoria){
    return categoriaRepositorio.save(categoria);
  }

  public CategoriaMeme encontrarCategoriaPorID(Long id){
    Optional<CategoriaMeme> opcategoria = categoriaRepositorio.findById(id);
      try {
        return opcategoria.get();
      } catch (NoSuchElementException e) {
        throw new RuntimeException("Categoria nao foi encontrada!", e);
      }
    }
}
