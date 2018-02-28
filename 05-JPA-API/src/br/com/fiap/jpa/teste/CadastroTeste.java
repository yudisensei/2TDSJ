package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Escolaridade;
import br.com.fiap.jpa.entity.Funcionario;

public class CadastroTeste {

	public static void main(String[] args) {
		//Cria a fabrica de "conexões"
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		//Cria a "conexão"
		EntityManager em = fabrica.createEntityManager();

		Funcionario f = new Funcionario("Humberto", new GregorianCalendar(1980, Calendar.JANUARY, 30),
				Calendar.getInstance(), 20000, null, Escolaridade.SUPERIOR);

		// cadastrar o funcionário
		em.persist(f);
		// iniciar uma transação
		em.getTransaction().begin();
		// finalizar com commit a transação
		em.getTransaction().commit();

		em.close();
		fabrica.close();
	}

}
