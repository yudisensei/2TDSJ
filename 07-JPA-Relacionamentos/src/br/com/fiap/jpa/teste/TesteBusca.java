package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.PedidoDAO;
import br.com.fiap.jpa.dao.impl.PedidoDAOImpl;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class TesteBusca {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		//Buscar o pedido
		PedidoDAO dao = new PedidoDAOImpl(em);
		Pedido pedido = dao.buscar(1);
		//Exibir a descrição do pedido
		System.out.println(pedido.getDescricao());
		//Exibir o valor da nota fiscal
		System.out.println(pedido.getNota().getValor());
		em.close();
		fabrica.close();
	}
	
}
