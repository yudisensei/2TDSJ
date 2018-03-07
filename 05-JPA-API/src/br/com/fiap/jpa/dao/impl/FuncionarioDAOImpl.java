package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.FuncionarioDAO;
import br.com.fiap.jpa.entity.Funcionario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.FuncionarioInexisteException;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	private EntityManager em;
	
	public FuncionarioDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void gravar(Funcionario func) {
		em.persist(func);
	}

	@Override
	public void apagar(int codigo) throws FuncionarioInexisteException {
		Funcionario f = buscar(codigo);
		if (f == null){
			throw new FuncionarioInexisteException();
		}
		em.remove(f);
	}

	@Override
	public void atualizar(Funcionario func) {
		em.merge(func);
	}

	@Override
	public Funcionario buscar(int codigo) {
		return em.find(Funcionario.class, codigo);
	}

	@Override
	public void commit() throws CommitException {
		try{
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			//Verifica se existe a transação ativa
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException("Erro ao realizar o commit");
		}
	}
	
	

}


