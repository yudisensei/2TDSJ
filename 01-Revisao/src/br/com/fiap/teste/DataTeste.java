package br.com.fiap.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataTeste {

	public static void main(String[] args) {
		//Criar um objeto com a data atual
		Calendar hoje = Calendar.getInstance();
		//Criar um objeto para formatar a data
		SimpleDateFormat sdf = 
				new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
		
		System.out.println(sdf.format(hoje.getTime()));
		
		//Transformar uma string em data
		String aniversarioItalo = "27/01/2000 15:30";
		
		try {
			Date niverItalo = sdf.parse(aniversarioItalo);
			System.out.println(niverItalo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar formatura = 
				new GregorianCalendar(2019, 
						Calendar.FEBRUARY, 10);
		System.out.println(sdf.format(formatura.getTime()));
		
	}
	
}








