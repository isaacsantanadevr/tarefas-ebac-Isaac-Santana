package ExemploVendasMod30.main.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import ExemploVendasMod30.main.domain.Cliente;
import ExemploVendasMod30.main.domain.Venda;
import ExemploVendasMod30.main.domain.Venda.Status;

public class VendaFactory {
    public static Venda convert(ResultSet rs) throws SQLException {
		Cliente cliente = ClienteFactory.convert(rs);
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setId(rs.getLong("ID_VENDA"));
		venda.setCodigo(rs.getString("CODIGO"));
		venda.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
		venda.setDataVenda(rs.getTimestamp("DATA_VENDA").toInstant());
		venda.setStatus(Status.getByName(rs.getString("STATUS_VENDA")));
		return venda;
	}
}
