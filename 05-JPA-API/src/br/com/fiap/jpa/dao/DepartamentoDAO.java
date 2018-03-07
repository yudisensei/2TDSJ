package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Departamento;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.DepartamentoNaoEncontradoException;

public interface DepartamentoDAO {

	void gravar(Departamento departamento);
	
	Departamento buscar(int codigo);
	
	void atualizar(Departamento departamento);
	
	void apagar(int codigo) throws DepartamentoNaoEncontradoException;
	
	void commit() throws CommitException;
	
}




