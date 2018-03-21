package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_FORNECEDOR")
@SequenceGenerator(name="fornecedor",sequenceName="SQ_T_FORNECEDOR",allocationSize=1)
public class Fornecedor {

	@Id
	@Column(name="cd_fornecedor")
	@GeneratedValue(generator="fornecedor",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_fornecedor",nullable=false)
	private String nome;
	
	@Column(name="ds_telefone",nullable=false,length=11)
	private String telefone;
	
	@ManyToMany(mappedBy="fornecedores")
	private List<Produto> produtos;

	public Fornecedor() {
		super();
	}

	public Fornecedor(String nome, String telefone, List<Produto> produtos) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.produtos = produtos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
