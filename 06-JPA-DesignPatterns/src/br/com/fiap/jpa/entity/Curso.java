package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CURSO")
@SequenceGenerator(name="curso",sequenceName="SQ_T_CURSO",allocationSize=1)
public class Curso {

	@Id
	@Column(name="cd_curso")
	@GeneratedValue(generator="curso",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_curso",length=50,nullable=false)
	private String nome;
	
	@Column(name="ds_carga_horaria")
	private int cargaHoraria;
	
	public Curso(String nome, int cargaHoraria) {
		super();
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
	}

	public Curso() {
		super();
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

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
}
