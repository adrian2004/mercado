package application;

import java.util.Date;

import model.dao.FabricaDao;
import model.dao.ProdutoDao;
import model.entities.Produto;
import model.entities.Setor;

public class Program {

	public static void main(String[] args) {
		
		ProdutoDao produtoDao = FabricaDao.criarProdutoDao();
		
		Produto produto = new Produto(null, "Carne", 40.0, new Date(), 10, new Setor(1, "alimentos"));
		
		//inserir
		//produtoDao.inserir(produto);
		//System.out.println("Produto inserido! Seu id é " + produto.getId());
		
		//buscar por id
		//System.out.println();
		//produto = produtoDao.buscarPorId(3);
		//System.out.println("Busca com sucesso! Resultado: " + produto);
		
		//buscar todos
		//System.out.println();
		//for(Produto p : produtoDao.buscarTodos()) {
		//	System.out.println(p);
		//}
		
		//buscar por id
		//System.out.println();
		//for(Produto p : produtoDao.buscarPorSetor(new Setor(1, "alimentos"))){
		//	System.out.println(p);
		//}
		
		//deletar
		//System.out.println();
		//produtoDao.deletar(2);
		//System.out.println("Deletado com sucesso!");
		
		//alterar
		System.out.println();
		produtoDao.alterar(4, produto);
		System.out.println("Sucesso!");
	}

}
