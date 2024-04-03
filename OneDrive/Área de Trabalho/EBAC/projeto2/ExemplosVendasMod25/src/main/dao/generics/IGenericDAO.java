package main.dao.generics;

import main.domain.Persistente;
import main.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

public interface IGenericDAO <T extends Persistente> {

    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    public void excluir(Long valor);

    public void alterar(T entity) throws TipoChaveNaoEncontradaException;

    public T consultar(Long valor);

    public Collection<T> buscarTodos();


}
