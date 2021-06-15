package application;

import model.dao.FabricaDao;
import model.dao.SetorDao;
import model.entities.Setor;

public class Program2 {

	public static void main(String[] args) {

		SetorDao setorDao = FabricaDao.criarSetorDao();
		
		Setor setor = new Setor(null, "limpeza");
		
		//inserir
		//setorDao.inserir(setor);
		//System.out.println("Inserção com sucesso!");

		//deletar
		setorDao.deletar(2);
		System.out.println("Deleção bem sucedida!");
		
	}

}
