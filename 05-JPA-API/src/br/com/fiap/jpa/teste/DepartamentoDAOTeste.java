package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.fiap.jpa.dao.DepartamentoDAO;
import br.com.fiap.jpa.dao.impl.DepartamentoDAOImpl;
import br.com.fiap.jpa.entity.Departamento;
import br.com.fiap.jpa.exception.CommitException;

public class DepartamentoDAOTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		DepartamentoDAO dao = new DepartamentoDAOImpl(em);
		//Cadastrar
		Departamento dep = new Departamento("Financeiro");
		
		try{
			dao.gravar(dep);
			dao.commit();
			System.out.println("Sucesso!");
		}catch(CommitException e){
			System.err.println(e.getMessage());
		}
		
		//Buscar
		Departamento depBusca = dao.buscar(dep.getCodigo());
		System.out.println(depBusca.getNome());
		
		//Atualizar
		try{
			depBusca.setNome("RH");
			dao.atualizar(depBusca);
			dao.commit();
			System.out.println("Atualizado!");
		}catch(CommitException e){
			System.err.println(e.getMessage());
		}
		
		//Remover
		try{
			dao.apagar(depBusca.getCodigo());
			dao.commit();
			System.out.println("Removido!");
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
		em.close();
		fabrica.close();
	}
	
}