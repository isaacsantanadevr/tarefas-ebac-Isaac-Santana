package main.dao;

import main.dao.generics.IGenericDAO;
import main.domain.Cliente;

public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

    /* Boolean salvar(Cliente cliente);
   
    Cliente buscarPorCPF(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente);
     */
}
