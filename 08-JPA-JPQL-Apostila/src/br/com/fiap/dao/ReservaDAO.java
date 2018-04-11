package br.com.fiap.dao;

import java.util.Calendar;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva,Integer>{

	long contarPorCliente(Cliente cliente);
	
	long contarPorDatas(Calendar inicio, Calendar fim);
	
}
