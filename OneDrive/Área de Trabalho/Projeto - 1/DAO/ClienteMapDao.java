package DAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Cadastro.Cliente;

public class ClienteMapDao implements IClienteDAO{

    private Map<Long, Cliente> map;

    public ClienteMapDao(){
        this.map = new HashMap<>();
    }

    public Cliente consultar(Long cpf){
        return this.map.get(cpf);
    }

    public void alterar(Cliente cliente){
        Cliente clientecadastrado = this.map.get(cliente.getCpf());
        if(clientecadastrado != null){
            cliente.setNome(cliente.getNome());
            cliente.setTel(cliente.getTel());
            cliente.setNumero(cliente.getNumero());
            cliente.setEnd(cliente.getEnd());
            cliente.setCidade(cliente.getCidade());
            cliente.setEstado(cliente.getEstado());
        }
    }
    
    public Collection<Cliente> buscarTodos(){
        return this.map.values();
    }

    public void excluir(Long cpf){
        Cliente clientecadastrado = this.map.get(cpf);

        if(clientecadastrado != null){
            this.map.remove(clientecadastrado.getCpf(), clientecadastrado);
        }
    }

    public boolean cadastrar(Cliente cliente){
        if(this.map.containsKey(cliente.getCpf())){
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }
}
