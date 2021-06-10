package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import model.dao.ProdutoDao;
import model.entities.Produto;
import model.entities.Setor;

public class ProdutoDaoJDBC implements ProdutoDao {

	private Connection conn = null;
	
	public ProdutoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(Produto produto) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO produto "
										+ "(nome, preco, validade, quantidade, fk_setor) "
										+ "VALUES (?, ?, ?, ?, ?)",
										Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, produto.getNome());
			st.setDouble(2, produto.getPreco());
			st.setDate(3, new java.sql.Date(produto.getValidade().getTime()));
			st.setInt(4, produto.getQuantidade());
			st.setInt(5, produto.getSetor().getId());
			
			int linhasAfetadas = st.executeUpdate();
			
			if(linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					produto.setId(id);
				}
				DB.fecharResultSet(rs);
			}
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			DB.fecharStatement(st);
		}
	}

	@Override
	public void deletar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(int id, Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> buscarPorSetor(Setor setor) {
		// TODO Auto-generated method stub
		return null;
	}
}
