package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_NOTA_FISCAL")
@SequenceGenerator(name="nota",sequenceName="SQ_T_NOTA_FISCAL",allocationSize=1)
public class NotaFiscal {

	@Id
	@Column(name="cd_nota_fiscal")
	@GeneratedValue(generator="nota",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="vl_nota_fiscal",nullable=false)
	private double valor;
	
	@Column(name="nr_serie")
	private String numeroSerie;
	
	@OneToOne(mappedBy="nota",cascade=CascadeType.PERSIST)//nome do atributo que mapeia a relação
	private Pedido pedido;
	
	public NotaFiscal() {
		super();
	}

	public NotaFiscal(double valor, String numeroSerie) {
		super();
		this.valor = valor;
		this.numeroSerie = numeroSerie;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}