package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_DEPARTAMENTO")
@SequenceGenerator(name="departamento",sequenceName="SQ_T_DEPARTAMENTO",allocationSize=1)
public class Departamento {

	@Id
	@Column(name="cd_departamento")
	@GeneratedValue(generator="departamento",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_departamento",nullable=false)
	private String nome;
	
	public Departamento() {
		super();
	}

	public Departamento(String nome) {
		super();
		this.nome = nome;
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
	
}