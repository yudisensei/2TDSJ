package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;

public class Teste {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		
		Date data1 = new Date("");
		
		Calendar data = Calendar.getInstance(); //ATUAL
		ContaCorrente cc = 
			new ContaCorrente(1,2,data,100,TipoConta.COMUM);
		
		Calendar data2 = 
			new GregorianCalendar(2018, Calendar.FEBRUARY, 2);
		
		ContaPoupanca cp = 
			new ContaPoupanca(1, 3, data2, 1000, 2);
		
		ContaCorrente cc1 = 
				new ContaCorrente(1,5,data,200,TipoConta.ESPECIAL);
		
		ContaCorrente cc2 = 
				new ContaCorrente(1,2,data,300,TipoConta.PREMIUM);
		
		List<ContaCorrente> lista = new ArrayList<>();
		lista.add(cc);
		lista.add(cc1);
		lista.add(cc2);
		
		for (ContaCorrente contaCorrente : lista) {
			System.out.println(contaCorrente.getSaldo());
		}
		
	}
	
}
