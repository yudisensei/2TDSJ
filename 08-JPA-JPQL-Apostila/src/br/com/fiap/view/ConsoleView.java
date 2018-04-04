package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		List<Cidade> cidades = cidadeDao.listar();
		System.out.println("LISTAR CIDADES");
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		cidades = cidadeDao.buscarPorMaiorNumeroHabitantes(100);
		System.out.println("BUSCAR POR NUMERO DE HABITANTES");
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome() + " " + cidade.getNrHabitantes());
		}
		
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		List<Cliente> clientes = clienteDao.listar();
		System.out.println("LISTAR CLIENTES");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		Transporte transporte = transporteDao.pesquisar(1);
		List<Pacote> pacotes = pacoteDao.listarPorTransporte(transporte);
		System.out.println("LISTAR PACOTE POR TRANSPORTE");
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
		}
		
		clientes = clienteDao.listarPorEstado("SP");
		System.out.println("LISTAR CLIENTE POR ESTADO");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		clientes = clienteDao.listarPorDiaReserva(10);
		System.out.println("LISTAR CLIENTE POR DIA RESERVA");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		clientes = clienteDao.listarPorNome("a");
		System.out.println("LISTAR CLIENTE POR NOME");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		em.close();
		fabrica.close();
	}

}



