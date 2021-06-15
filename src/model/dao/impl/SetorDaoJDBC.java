package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO setor (nome) "
										+ "VALUES (?)");
			
			st.setString(1, setor.getNome());
			
			st.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void deletar(int id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM setor WHERE id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		
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
