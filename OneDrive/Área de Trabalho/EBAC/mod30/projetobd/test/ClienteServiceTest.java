package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.dao.IClienteDAO;
import main.domain.Cliente;
import main.exceptions.DAOException;
import main.exceptions.TipoChaveNaoEncontradaException;
import main.services.ClienteService;
import main.services.IClienteService;
import test.dao.ClienteDaoMock;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {

        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);

    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Isaac");
        cliente.setCidade("Orlando");
        cliente.setEnd("End");
        cliente.setEstado("Florida");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        //clienteService.salvar(cliente);
    }

    @Test
    public void pesquisarCliente() throws DAOException {

        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
        Boolean retorno = clienteService.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() throws DAOException {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
        cliente.setNome("Isaac Santana");
        clienteService.alterar(cliente);

        Assert.assertEquals("Isaac Santana", cliente.getNome());
    }

}
