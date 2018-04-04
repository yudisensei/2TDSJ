package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	List<Cliente> listarPorEstado(String estado);
	
	List<Cliente> listarPorDiaReserva(int dias);
	
	List<Cliente> listarPorNome(String nome);
	
}