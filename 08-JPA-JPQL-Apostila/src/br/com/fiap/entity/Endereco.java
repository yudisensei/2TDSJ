package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="JPA_T_ENDERECO")
@SequenceGenerator(name="seqEndereco", sequenceName="SEQ_JPA_T_ENDERECO", allocationSize=1)
public class Endereco {

	@Id
	@Column(name="cd_endereco")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqEndereco")
	private int id;
	
	@Column(nullable=false,name="ds_logradouro")
	private String logradouro;
	
	@Column(nullable=false,name="nr_cep")
	private Integer cep;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Cidade cidade;
	
	public Endereco(String logradouro, Integer cep, Cidade cidade) {
		super();
		this.logradouro = logradouro;
		this.cep = cep;
		this.cidade = cidade;
	}
	
	public Endereco() {
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public int getId() {
		return id;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}
