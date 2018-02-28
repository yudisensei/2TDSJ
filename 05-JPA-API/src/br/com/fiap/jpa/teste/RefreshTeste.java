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

		//Buscar um funcion�rio
		Funcionario f = em.find(Funcionario.class, 1);
		
		//Exibir o sal�rio
		System.out.println(f.getSalario());
		
		//Alterar o sal�rio no java
		f.setSalario(300000);
		
		//Exibir o sal�rio
		System.out.println(f.getSalario());
		
		//Fazer o refresh
		em.refresh(f);
		
		//Exibir o sal�rio
		System.out.println(f.getSalario());
		
		em.close();
		fabrica.close();
	}
	
}
