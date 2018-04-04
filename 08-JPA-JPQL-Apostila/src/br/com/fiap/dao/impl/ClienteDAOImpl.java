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
		return em.createQuery("from Cliente c where c.nome like :n",Cliente.class)
			.setParameter("n", "%"+nome+"%")
			.getResultList();
	}

}







