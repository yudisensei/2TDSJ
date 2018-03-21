package br.com.fiap.jpa.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.NotaFiscalDAO;
import br.com.fiap.jpa.dao.PedidoDAO;
import br.com.fiap.jpa.dao.impl.NotaFiscalDAOImpl;
import br.com.fiap.jpa.dao.impl.PedidoDAOImpl;
import br.com.fiap.jpa.entity.Fornecedor;
import br.com.fiap.jpa.entity.ItemPedido;
import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.entity.Produto;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class TesteCadastro {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		PedidoDAO pedidoDao = new PedidoDAOImpl(em);
		
		NotaFiscal nota = new NotaFiscal(100, "123456");
		Pedido pedido = new Pedido("Churros",
							Calendar.getInstance(), nota);
		
		//Cadastrar os itens, produto e fornecedores
		Fornecedor f1 = new Fornecedor("Coca-Cola","4654654",null);
		Fornecedor f2 = new Fornecedor("Ambev","4564646",null);
		
		List<Fornecedor> fornecedores = new ArrayList<>();
		fornecedores.add(f1);
		fornecedores.add(f2);
		
		Produto p1 = new Produto("Churros", true, fornecedores);
		Produto p2 = new Produto("Refrigerante",true, fornecedores);
		
		ItemPedido i1 = new ItemPedido(10,2,p1,pedido);
		ItemPedido i2 = new ItemPedido(5,2,p2,pedido);
		
		pedido.adicionarItem(i1);
		pedido.adicionarItem(i2);
		
		try {
			pedidoDao.gravar(pedido);
			pedidoDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
	
}
