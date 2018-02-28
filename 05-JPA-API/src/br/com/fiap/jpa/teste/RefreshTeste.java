package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Funcionario;

public class RefreshTeste {

	public static void main(String[] args) {
		//Criar o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		//Buscar um funcionário
		Funcionario f = em.find(Funcionario.class, 1);
		
		//Exibir o salário
		System.out.println(f.getSalario());
		
		//Alterar o salário no java
		f.setSalario(300000);
		
		//Exibir o salário
		System.out.println(f.getSalario());
		
		//Fazer o refresh
		em.refresh(f);
		
		//Exibir o salário
		System.out.println(f.getSalario());
		
		em.close();
		fabrica.close();
	}
	
}
