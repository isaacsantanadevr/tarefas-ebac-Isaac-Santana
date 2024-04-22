package main.services;

import main.domain.Cliente;
import main.exceptions.DAOException;
import main.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    //Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCPF(Long cpf) throws DAOException;

    //void excluir(Long cpf);

    //void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
    
}
