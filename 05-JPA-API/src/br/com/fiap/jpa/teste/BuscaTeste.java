package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Funcionario;

public class BuscaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

						//Classe (Tabela), Chave primária
		Funcionario f = em.find(Funcionario.class, 2);
		
		System.out.println(f.getNome());
		System.out.println(f.getSalario());
		
		em.close();
		fabrica.close();
	}
}




