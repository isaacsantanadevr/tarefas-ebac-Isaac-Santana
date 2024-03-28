package com.ebac.test;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

    public class ContratoServiceTestTarefa {

        @Test
        public void salvarTeste() {
            IContratoDao dao = new ContratoDaoMock();
            IContratoService service = new ContratoService(dao);
            String retorno = service.salvar();
            Assert.assertEquals("Sucesso", retorno);
        }

        /* Tarefa Criando testes(buscar, excluir, atualizar) */

        @Test
        public void buscarTeste() {
            IContratoDao dao = new ContratoDaoMock();
            IContratoService serviceB = new ContratoService(dao);
            String retornoB = serviceB.buscar();
            Assert.assertEquals("Buscando Cliente", retornoB);
        }

        @Test
        public void excluirTeste() {
            IContratoDao dao = new ContratoDaoMock();
            IContratoService serviceE = new ContratoService(dao);
            String retornoE = serviceE.excluir();
            Assert.assertEquals("Cliente Deletado", retornoE);
        }

        @Test
        public void atualizarTeste() {
            IContratoDao dao = new ContratoDaoMock();
            IContratoService serviceA = new ContratoService(dao);
            String retornoA = serviceA.atualizar();
            Assert.assertEquals("Dados atualizados com sucesso", retornoA);
        }

        /**
         * @testes de erro
         */

        @Test(expected = UnsupportedOperationException.class)
        public void esperadoErroNoSalvarComBancoDeDadosTest() {
            IContratoDao dao = new ContratoDao();
            IContratoService service = new ContratoService(dao);
            String retorno = service.salvar();
            Assert.assertEquals("Sucesso", retorno);
        }

        /* Tarefa Criando testes(buscar, excluir, atualizar) */

        @Test(expected = UnsupportedOperationException.class)
        public void esperadoErrobuscarComBancoDeDadosTest() {
            IContratoDao dao = new ContratoDao();
            IContratoService serviceB = new ContratoService(dao);
            String retornoB = serviceB.buscar();
            Assert.assertEquals("Buscando Cliente", retornoB);
        }

        @Test(expected = UnsupportedOperationException.class)
        public void esperadoErroexcluirtComBancoDeDadosTest() {
            IContratoDao dao = new ContratoDao();
            IContratoService serviceE = new ContratoService(dao);
            String retornoE = serviceE.excluir();
            Assert.assertEquals("Cliente Deletado", retornoE);
        }

        @Test(expected = UnsupportedOperationException.class)
        public void esperadoErroAtualizartComBancoDeDadosTest() {
            IContratoDao dao = new ContratoDao();
            IContratoService serviceA = new ContratoService(dao);
            String retornoA = serviceA.atualizar();
            Assert.assertEquals("Cliente Deletado", retornoA);
        }

    }
}


}
