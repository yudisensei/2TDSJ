package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Funcionario;

public class RemoveTeste {

	public static void main(String[] args) {
		//Criar o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar o funcionario
		Funcionario f = em.find(Funcionario.class, 1);
		
		//Remover o funcionario
		em.remove(f);
		
		//transações
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
		
	}
	
}