package model.dao;

import java.util.List;

import model.entities.Setor;

public interface SetorDao {

	void inserir(Setor setor);
	void deletar(int id);
	void alterar(int id, Setor setor);
	Setor buscarPorId(int id);
	List<Setor> buscarTodos();
}
