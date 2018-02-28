package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_FUNCIONARIO")
@SequenceGenerator(name="funcionario",sequenceName="SQ_T_FUNCIONARIO",
allocationSize=1)
public class Funcionario {

	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(generator="funcionario",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_funcionario",nullable=false,length=100)
	private String nome;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_admissao",nullable=false)
	private Calendar dataAdmissao;
	
	@Column(name="vl_salario")
	private double salario;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Column(name="ds_escolaridade",nullable=false)
	private Escolaridade escolaridade;
	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, Calendar dataNascimento, Calendar dataAdmissao, double salario, byte[] foto,
			Escolaridade escolaridade) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
		this.foto = foto;
		this.escolaridade = escolaridade;
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}
	
}