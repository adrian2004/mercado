package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
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
		} finally {
			DB.fecharStatement(st);
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
		} finally {
			DB.fecharStatement(st);
		}
		
	}

	@Override
	public void alterar(int id, Setor setor) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE setor "
										+ "SET nome = ? "
										+ "WHERE id = ?");
			st.setString(1, setor.getNome());
			st.setInt(2, id);
			
			st.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			DB.fecharStatement(st);
		}
		
	}

	@Override
	public Setor buscarPorId(int id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM setor WHERE id = ?");
			
			st.setInt(1, id);
			
			rs = st.executeQuery();
			if(rs.next()) {
				Setor set = instanciarSetor(rs);
				
				return set;
			}
			return null;
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(st);
		}
	}

	@Override
	public List<Setor> buscarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM setor");
			
			rs = st.executeQuery();
			List<Setor> list = new ArrayList<>();
			while(rs.next()) {
				Setor set = instanciarSetor(rs);
				
				list.add(set);
			}
			return list;
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(st);
		}
	}

	private Setor instanciarSetor(ResultSet rs) throws SQLException {
		Setor setor = new Setor();
		
		setor.setId(rs.getInt("id"));
		setor.setNome(rs.getString("nome"));
		
		return setor;
	}
}
