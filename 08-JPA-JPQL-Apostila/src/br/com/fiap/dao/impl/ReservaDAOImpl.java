package br.com.fiap.dao.impl;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva, Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public long contarPorCliente(Cliente cliente) {
		return em.createQuery("select count(r) from Reserva r " + "where r.cliente = :cli", Long.class)
				.setParameter("cli", cliente).getSingleResult();
	}

	@Override
	public long contarPorDatas(Calendar inicio, Calendar fim) {
		return em.createNamedQuery("Reserva.contarPorData", Long.class)
				.setParameter("i", inicio).setParameter("f", fim)
				.getSingleResult();
	}

}
