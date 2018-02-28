package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Funcionario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.FuncionarioInexisteException;

public interface FuncionarioDAO {

	//Assinaturas dos métodos
	
	void gravar(Funcionario func);
	
	void apagar(int codigo) throws FuncionarioInexisteException;
	
	void atualizar(Funcionario func);
	
	Funcionario buscar(int codigo);
	
	void commit() throws CommitException ;
	
}





