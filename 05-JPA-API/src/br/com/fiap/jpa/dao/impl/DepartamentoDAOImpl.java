package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.DepartamentoDAO;
import br.com.fiap.jpa.entity.Departamento;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.DepartamentoNaoEncontradoException;

public class DepartamentoDAOImpl implements DepartamentoDAO {

	private EntityManager em;
	
	public DepartamentoDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void gravar(Departamento departamento) {
		em.persist(departamento);
	}

	@Override
	public Departamento buscar(int codigo) {
		return em.find(Departamento.class, codigo);
	}

	@Override
	public void atualizar(Departamento departamento) {
		em.merge(departamento);
	}

	@Override
	public void apagar(int codigo) throws DepartamentoNaoEncontradoException {
		Departamento dep = buscar(codigo);
		if (dep == null){
			throw new DepartamentoNaoEncontradoException();
		}
		em.remove(dep);
	}

	@Override
	public void commit() throws CommitException {
		try{
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new CommitException("Erro ao gravar");
		}
		
	}

}
