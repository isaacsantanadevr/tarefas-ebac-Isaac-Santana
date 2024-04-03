package teste.dao;

import main.dao.IClienteDAO;
import main.domain.Cliente;
import main.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDaoMock implements IClienteDAO {

    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public Cliente buscaCPF(Long cpf) {
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        return cliente;
    }

    @Override
    public void excluir(Long cpf) {

    }

    @Override
    public void alterar(Cliente cliente) throws  TipoChaveNaoEncontradaException{

    }
}
