package main.services;

import main.dao.IProdutoDao;
import main.domain.Produto;
import main.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDao dao) {
		super(dao);
	}
    
}
