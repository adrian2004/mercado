package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.FabricaDao;
import model.dao.SetorDao;
import model.entities.Setor;

public class Program2 {

	public static void main(String[] args) {

		SetorDao setorDao = FabricaDao.criarSetorDao();
		
		Setor setor = new Setor(null, "bebidas");
		
		//inserir
		//setorDao.inserir(setor);
		//System.out.println("Inserção com sucesso!");

		//deletar
		//setorDao.deletar(2);
		//System.out.println("Deleção bem sucedida!");
		
		//alterar
		//setorDao.alterar(1, setor);
		//System.out.println("Alteração bem sucedida!");
		
		//buscar por id
		//setor = setorDao.buscarPorId(1);
		//System.out.println("Resultado da busca: " + setor);
		
		//buscar todos
		List<Setor> list = setorDao.buscarTodos();
		for(Setor s : list) {
			System.out.println(s);
		}
		System.out.println("Fim da busca.");
	}

}
