package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity 
@Table(name="TB_VEICULO")
@SequenceGenerator(name="veiculo",sequenceName="SQ_TB_VEICULO",allocationSize=1)
public class Veiculo {

	@Id
	@GeneratedValue(generator="veiculo",strategy=GenerationType.SEQUENCE)
	@Column(name="cd_veiculo")
	private int codigo;
	
	@Column(name="ds_modelo", nullable=false, length=70)
	private String modelo;
	
	@Column(name="ds_ano")
	private int ano;
	
	@Column(name="ds_cor",length=20)
	private String cor;
	
	@Transient // não será mapeada para uma coluna no banco
	private int chaveAcesso;

	@Temporal(TemporalType.DATE) //Somente a data no banco
	@Column(name="dt_fabricacao")
	private Calendar dataFabricacao;
	
	@Lob //gravar arquivo no banco de dados
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_combustivel")
	private Combustivel combustivel;
	
	public Veiculo() {
		super();
	}

	public Veiculo(String modelo, int ano, String cor, int chaveAcesso, Calendar dataFabricacao, byte[] foto,
			Combustivel combustivel) {
		super();
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.chaveAcesso = chaveAcesso;
		this.dataFabricacao = dataFabricacao;
		this.foto = foto;
		this.combustivel = combustivel;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getChaveAcesso() {
		return chaveAcesso;
	}

	public void setChaveAcesso(int chaveAcesso) {
		this.chaveAcesso = chaveAcesso;
	}

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	
}





