package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listarPorEstado(String estado) {
		return em.createQuery(
			"from Cliente c where c.endereco.cidade.uf = :es",Cliente.class)
			.setParameter("es", estado)
			.getResultList();
	}

	@Override
	public List<Cliente> listarPorDiaReserva(int dias) {		
		return em.createQuery(
			"select r.cliente from Reserva r where "
			+ "r.numeroDias = :d",Cliente.class)
			.setParameter("d", dias)
			.getResultList();
	}

	@Override
	public List<Cliente> listarPorNome(String nome) {		
		return em.createQuery("from Cliente c where upper(c.nome) like upper(:n)",Cliente.class)
			.setParameter("n", "%"+nome+"%")
			.setMaxResults(10) //Configura o máximo de resultados
			.getResultList();
	}

	@Override
	public List<Cliente> listar(String nome, String cidade) {
		return em.createQuery("from Cliente c where c.nome like :n and "
				+ "c.endereco.cidade.nome like :c",Cliente.class)
				.setParameter("n", "%" + nome + "%")
				.setParameter("c", "%" + cidade + "%")
				.getResultList();
	}

	@Override
	public List<Cliente> listarPorEstados(List<String> estados) {
		return em.createQuery("from Cliente c where "
				+ "c.endereco.cidade.uf in :e",Cliente.class)
				.setParameter("e", estados)
				.getResultList();
	}

	@Override
	public long contar() {
		return em.createQuery("select count(c) from Cliente c"
				,Long.class).getSingleResult();
	}

	@Override
	public List<Cliente> listarPorReservaAtiva() {
		return em.createQuery("select r.cliente from "
				+ "Reserva r where r.dataReserva > "
				+ "current_date",Cliente.class)
				.getResultList();
	}

}







