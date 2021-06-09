package model.dao;

import java.util.List;

import model.entities.Produto;
import model.entities.Setor;

public interface ProdutoDao {

	void inserir(Produto produto);
	void deletar(int id);
	void alterar(int id, Produto produto);
	Produto buscarPorId(int id);
	List<Produto> buscarTodos();
	List<Produto> buscarPorSetor(Setor setor);
}
