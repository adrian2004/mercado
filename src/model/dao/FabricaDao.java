package model.dao;

import db.DB;
import model.dao.impl.ProdutoDaoJDBC;

public class FabricaDao {

	public static ProdutoDao criarProdutoDao() {
		return new ProdutoDaoJDBC(DB.getConnection());
	}
}
