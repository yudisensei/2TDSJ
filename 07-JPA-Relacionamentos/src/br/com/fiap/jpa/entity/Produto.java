package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PRODUTO")
@SequenceGenerator(name="produto",sequenceName="SQ_T_PRODUTO",allocationSize=1)
public class Produto {

	@Id
	@Column(name="cd_produto")
	@GeneratedValue(generator="produto",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_produto",nullable=false)
	private String descricao;
	
	@Column(name="ds_perecivel",nullable=false)
	private boolean perecivel;

	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="T_PRODUTO_FORNECEDOR",
		joinColumns=@JoinColumn(name="cd_produto"),
		inverseJoinColumns=@JoinColumn(name="cd_fornecedor"))	
	private List<Fornecedor> fornecedores;
	
	public Produto() {
		super();
	}

	public Produto(String descricao, boolean perecivel, List<Fornecedor> fornecedores) {
		super();
		this.descricao = descricao;
		this.perecivel = perecivel;
		this.fornecedores = fornecedores;
	}

	public Produto(String descricao, boolean perecivel) {
		super();
		this.descricao = descricao;
		this.perecivel = perecivel;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isPerecivel() {
		return perecivel;
	}

	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	
}
