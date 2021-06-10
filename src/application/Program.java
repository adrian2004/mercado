package application;

import java.util.Date;

import model.dao.FabricaDao;
import model.dao.ProdutoDao;
import model.entities.Produto;
import model.entities.Setor;

public class Program {

	public static void main(String[] args) {
		
		ProdutoDao produtoDao = FabricaDao.criarProdutoDao();
		
		Produto produto = new Produto(null, "Macarrão", 15.0, new Date(), 2, new Setor(1, "alimentos"));
		
		produtoDao.inserir(produto);
		System.out.println("Produto inserido! Seu id é " + produto.getId());
	}

}
