package application;

import java.util.Date;

import model.dao.FabricaDao;
import model.dao.ProdutoDao;
import model.entities.Produto;
import model.entities.Setor;

public class Program {

	public static void main(String[] args) {
		
		ProdutoDao produtoDao = FabricaDao.criarProdutoDao();
		
		Produto produto = new Produto(null, "Carne", 45.0, new Date(), 5, new Setor(1, "alimentos"));
		
		//inserir
		//produtoDao.inserir(produto);
		//System.out.println("Produto inserido! Seu id é " + produto.getId());
		
		//buscar por id
		//System.out.println();
		produto = produtoDao.buscarPorId(3);
		System.out.println("Busca com sucesso! Resultado: " + produto);
	}

}
