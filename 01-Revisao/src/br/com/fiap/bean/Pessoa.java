package br.com.fiap.bean;

public abstract class Pessoa {

	private String nome;
	
	public void gravar(){
		System.out.println("Gravando..");
	}
	
	public abstract void apagar();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}