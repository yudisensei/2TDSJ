package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.CursoDAO;
import br.com.fiap.jpa.entity.Curso;

public class CursoDAOImpl 
				extends GenericDAOImpl<Curso, Integer> 
											implements CursoDAO {

	public CursoDAOImpl(EntityManager em) {
		super(em);
	}

	
	
}