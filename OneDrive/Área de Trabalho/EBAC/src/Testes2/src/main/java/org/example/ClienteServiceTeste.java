package org.example;

import org.junit.Assert;
import org.junit.Test;

public class ClienteServiceTeste {

    @Test
    public void salvarTeste(){
        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String rt = service.salvar();
        Assert.assertEquals("Sucesso", rt);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest() {
        IClienteDao mockDao = new ClienteDao();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }
}
}
