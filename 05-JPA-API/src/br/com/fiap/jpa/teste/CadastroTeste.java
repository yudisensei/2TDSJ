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
		//Cria a fabrica de "conex�es"
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		//Cria a "conex�o"
		EntityManager em = fabrica.createEntityManager();

		Funcionario f = new Funcionario("Humberto", new GregorianCalendar(1980, Calendar.JANUARY, 30),
				Calendar.getInstance(), 20000, null, Escolaridade.SUPERIOR);

		// cadastrar o funcion�rio
		em.persist(f);
		// iniciar uma transa��o
		em.getTransaction().begin();
		// finalizar com commit a transa��o
		em.getTransaction().commit();

		em.close();
		fabrica.close();
	}

}
