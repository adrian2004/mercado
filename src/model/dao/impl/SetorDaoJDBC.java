package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.SetorDao;
import model.entities.Setor;

public class SetorDaoJDBC implements SetorDao {
	
	Connection conn = null;
	
	public SetorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(Setor setor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(int id, Setor setor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Setor buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Setor> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
