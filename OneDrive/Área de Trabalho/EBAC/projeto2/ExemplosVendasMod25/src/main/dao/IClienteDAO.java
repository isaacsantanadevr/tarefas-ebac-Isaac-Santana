package main.dao;

import main.domain.Cliente;
import main.exceptions.TipoChaveNaoEncontradaException;

public interface IClienteDAO {
    Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscaCPF(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
