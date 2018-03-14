package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.AlunoDAO;
import br.com.fiap.jpa.dao.impl.AlunoDAOImpl;
import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontrado;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		AlunoDAO dao = new AlunoDAOImpl(em);
		//Cadastrar
		Aluno aluno = new Aluno("1234", "Juninho", 
				new GregorianCalendar(1999,Calendar.MARCH,14));
		try {
			dao.gravar(aluno);
			dao.commit();
			System.out.println("Cadastrado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		//Buscar
		Aluno busca = dao.buscar("1234");
		//Atualizar
		try {
			busca.setNome("Juninho Jr.");
			dao.atualizar(busca);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		//Remover
		try {
			dao.apagar("1234");
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		fabrica.close();
	}
	
}
