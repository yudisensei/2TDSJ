package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Escolaridade;
import br.com.fiap.jpa.entity.Funcionario;

public class AtualizaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		//Busca um funcionário no banco de dados
		Funcionario f = em.find(Funcionario.class, 1);
		//Cria um novo funcionário com os dados para atualização
		Funcionario f2 = 
			new Funcionario(f.getNome(), 
					f.getDataNascimento(), 
					f.getDataAdmissao(), 
					1000, f.getFoto(), f.getEscolaridade());
		
		f2.setCodigo(f.getCodigo());

		em.merge(f2); //Atualiza o funcionário
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
	
}