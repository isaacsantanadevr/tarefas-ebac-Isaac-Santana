package main.services;

import main.dao.IClienteDAO;
import main.domain.Cliente;

public class clienteService implements IClienteServices{

    private IClienteDAO clienteDAO;

    public clienteService(IClienteDAO dao){
        this.clienteDAO = dao;
    }

    @Override
    public Boolean salvar(Cliente cliente) {
        return clienteDAO.salvar(cliente);
    }

    @Override
    public Cliente buscarCPF(Long cpf) {
        return clienteDAO.buscaCPF(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        clienteDAO.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) {
        clienteDAO.alterar(cliente);
    }


}
