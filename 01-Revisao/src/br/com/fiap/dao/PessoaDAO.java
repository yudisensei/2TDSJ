package br.com.fiap.dao;

import br.com.fiap.bean.Pessoa;

public interface PessoaDAO {

	void gravar(Pessoa pessoa);
	void apagar(int id);
}
