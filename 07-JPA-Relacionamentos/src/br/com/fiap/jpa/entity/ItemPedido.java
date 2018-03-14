package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ITEM_PEDIDO")
@SequenceGenerator(name="item",sequenceName="SQ_T_ITEM_PEDIDO",allocationSize=1)
public class ItemPedido {

	@Id
	@Column(name="cd_item_pedido")
	@GeneratedValue(generator="item",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="vl_item_pedido")
	private double valor;
	
	@Column(name="qt_item_pedido")
	private int quantidade;
	
	@ManyToOne
	@JoinColumn(name="cd_pedido",nullable=false)
	private Pedido pedido;

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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}