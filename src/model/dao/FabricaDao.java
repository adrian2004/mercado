package model.dao;

import db.DB;
import model.dao.impl.ProdutoDaoJDBC;
import model.dao.impl.SetorDaoJDBC;

public class FabricaDao {

	public static ProdutoDao criarProdutoDao() {
		return new ProdutoDaoJDBC(DB.getConnection());
	}
	
	public static SetorDao criarSetorDao() {
		return new SetorDaoJDBC(DB.getConnection());
	}
}
