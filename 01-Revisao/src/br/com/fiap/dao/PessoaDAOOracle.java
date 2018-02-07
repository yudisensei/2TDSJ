package br.com.fiap.dao;

import java.io.Serializable;

import br.com.fiap.bean.Pessoa;

public class PessoaDAOOracle implements PessoaDAO, Serializable {

	private static final long serialVersionUID = 7714757157285738881L;

	@Override
	public void gravar(Pessoa pessoa) {
		System.out.println("Gravando no oracle");
	}

	@Override
	public void apagar(int id) {
		System.out.println("Apagando do oracle");
	}
	
}
