package br.com.ebac.meme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ebac.meme.entity.Meme;
import br.com.ebac.meme.repository.MemelandiaRepositorio;

@Component
public class MemelandiaServico {

  @Autowired
  private final MemelandiaRepositorio memelandiaRepositorio;

  public MemelandiaServico(MemelandiaRepositorio memelandiaRepositorio){
    this.memelandiaRepositorio = memelandiaRepositorio;
  }

  public Meme criarMeme(Meme meme){
    return memelandiaRepositorio.save(meme);
  }

  public Iterable<Meme> acharTodosMemes(){
    return memelandiaRepositorio.findAll();
  }

}
