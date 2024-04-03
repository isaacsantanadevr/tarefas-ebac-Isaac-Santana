package teste.dao;

import main.dao.ClienteDAO;
import main.dao.IClienteDAO;
import main.domain.Cliente;
import main.exceptions.TipoChaveNaoEncontradaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteDaoTest {

    private IClienteDAO clienteDao;
    private Cliente cliente;

    public ClienteDaoTest(){
        clienteDao = new ClienteDaoMock();
    }

    @BeforeEach
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setNome("Isaac");
        cliente.setCpf(12312312312L);
        cliente.setCidade("Salvador");
        cliente.setEnd("End");
        cliente.setNumero(10);
        cliente.setTel(77988880000L);

        clienteDao.salvar(cliente);
    }


    @Test
    public void pesquisarCliente(){
        Cliente consultado = clienteDao.buscaCPF(cliente.getCpf());

        assertNotNull(consultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException{
        Boolean retorno = clienteDao.salvar(cliente);
        assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException{
        cliente.setNome("Isaac Santana");
        clienteDao.alterar(cliente);

        assertEquals("Isaac Santana", cliente.getNome());
    }

}
