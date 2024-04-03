package main.dao;

import main.domain.Cliente;

public class ClienteDAO implements IClienteDAO {

    public Boolean salvar(Cliente cliente) {
        return true;
    }

    @Override
    public Cliente buscaCPF(Long cpf) {
        return null;
    }

    @Override
    public void excluir(Long cpf) {

    }

    @Override
    public void alterar(Cliente cliente) {

    }
}
