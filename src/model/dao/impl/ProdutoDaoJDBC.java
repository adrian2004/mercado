package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM produto WHERE id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			DB.fecharStatement(st);
		}
		
	}

	@Override
	public void alterar(int id, Produto produto) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE produto "
										+ "SET nome = ?, preco = ?, validade = ?, quantidade = ?, fk_setor = ? "
										+ "WHERE id = ?");
			
			st.setString(1, produto.getNome());
			st.setDouble(2, produto.getPreco());
			st.setDate(3, new java.sql.Date(produto.getValidade().getTime()));
			st.setInt(4, produto.getQuantidade());
			st.setInt(5, produto.getSetor().getId());
			st.setInt(6, id);
			
			int linhas = st.executeUpdate();
			if(linhas != 0) {
				System.out.println(linhas + " linhas alteradas");
			}
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			DB.fecharStatement(st);
		}
		
	}

	@Override
	public Produto buscarPorId(int id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT produto.*,setor.nome AS nomeSetor FROM produto "
										+ "INNER JOIN setor ON produto.fk_setor = setor.id "
										+ "WHERE produto.id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Setor set = instanciarSetor(rs);
				Produto prod = instanciarProduto(rs, set);
				
				return prod;
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
	public List<Produto> buscarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT produto.*,setor.nome AS nomeSetor FROM produto "
										+ "INNER JOIN setor ON produto.fk_setor = setor.id");
			
			rs = st.executeQuery();
			
			List<Produto> list = new ArrayList<>();
			while(rs.next()) {
				Setor set = instanciarSetor(rs);
				Produto prod = instanciarProduto(rs, set);
				
				list.add(prod);
			}
			return list;
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Produto> buscarPorSetor(Setor setor) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT produto.*,setor.nome AS nomeSetor FROM produto "
										+ "INNER JOIN setor ON produto.fk_setor = setor.id "
										+ "WHERE setor.id = ?");
			
			st.setInt(1, setor.getId());
			
			rs = st.executeQuery();
			
			List<Produto> list = new ArrayList<>();
			while(rs.next()) {
				Setor set = instanciarSetor(rs);
				Produto prod = instanciarProduto(rs, set);
				
				list.add(prod);
			}
			return list;
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	private Produto instanciarProduto(ResultSet rs, Setor set) throws SQLException {
		Produto produto = new Produto();
		
		produto.setId(rs.getInt("id"));
		produto.setNome(rs.getString("nome"));
		produto.setPreco(rs.getDouble("preco"));
		produto.setValidade(rs.getDate("validade"));
		produto.setQuantidade(rs.getInt("quantidade"));
		produto.setSetor(set);
		
		return produto;
	}
	
	private Setor instanciarSetor(ResultSet rs) throws SQLException {
		Setor setor = new Setor();
		
		setor.setId(rs.getInt("fk_setor"));
		setor.setNome(rs.getString("nomeSetor"));
		
		return setor;
	}
}
