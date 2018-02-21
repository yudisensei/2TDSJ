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
	
	
}





