package DAO;

import java.util.Collection;
import Cadastro.Cliente;

public interface IClienteDAO {
    public boolean cadastrar(Cliente cliente);
    public void excluir(Long cpf);
    public void alterar(Cliente cliente);
    public Cliente consultar(Long cpf);
    public Collection<Cliente> buscarTodos();
}
