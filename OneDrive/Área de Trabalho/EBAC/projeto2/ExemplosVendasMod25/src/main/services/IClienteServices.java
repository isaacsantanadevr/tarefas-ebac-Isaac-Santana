package main.services;

import main.domain.Cliente;

public interface IClienteServices {

    Boolean salvar(Cliente cliente);
    Cliente buscarCPF(Long cpf);
    void excluir(Long cpf);
    void alterar(Cliente cliente);
}
