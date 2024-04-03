package teste;

import main.dao.IClienteDAO;
import main.domain.Cliente;
import main.exceptions.TipoChaveNaoEncontradaException;
import main.services.IClienteServices;
import main.services.clienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import teste.dao.ClienteDaoMock;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteServiceTest {

    public IClienteServices clienteServices;
    private Cliente cliente;

    public ClienteServiceTest(){
        IClienteDAO dao = new ClienteDaoMock();
        clienteServices = new clienteService(dao);
    }

    @BeforeEach
    public void init(){
        cliente = new Cliente();
        cliente.setNome("Isaac");
        cliente.setCpf(12312312312L);
        cliente.setCidade("Salvador");
        cliente.setEnd("End");
        cliente.setNumero(10);
        cliente.setTel(77988880000L);

    }

    @Test
    public void pesquisarCliente(){

        Cliente consultado = clienteServices.buscarCPF(cliente.getCpf());

        assertNotNull(consultado);
    }

    @Test
    public void salvarCliente(){
        Boolean retorno = clienteServices.salvar(cliente);
        assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteServices.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Isaac Santana");
        clienteServices.alterar(cliente);

        assertEquals("Isaac Santana", cliente.getNome());
    }

}