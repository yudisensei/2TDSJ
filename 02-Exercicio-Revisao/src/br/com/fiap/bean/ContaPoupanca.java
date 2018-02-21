package br.com.fiap.bean;

import java.util.Calendar;

public class ContaPoupanca extends Conta implements ContaInvestimento{

	private float taxa;
	
	private static final float RENDIMENTO = 0.005f;
	
	@Override
	public double calculaRetornoInvestimento() {
		return saldo*RENDIMENTO;
	}

	@Override
	public void retirar(double valor) throws Exception {
		if (saldo >= valor + taxa){
			saldo -= valor + taxa;
		}else{
			throw new Exception("Saldo insuficiente");
		}
	}

	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	public ContaPoupanca() {
		super();
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}
