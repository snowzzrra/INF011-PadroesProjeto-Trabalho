package br.edu.inf011.aval3.enunciado.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.edu.inf011.aval3.visitor.Visitor;
import br.edu.inf011.aval3.visitor.VisitorValidar;

public class RG implements Documento{
	
	private String nome;
	private String numero;
	private String expedidor;
	private LocalDate validade;
	
	
	//ATRIBUTO NOVO
	private String rgFormatado;
	private boolean isValido;
	private Integer pontuacao;
	
	public RG(String nome, String numero, String expedidor, LocalDate validade) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.expedidor = expedidor;
		this.validade = validade;
	}
	
	
	public RG(String nome, String numero, String expedidor, String validade) {
		this(nome, numero, expedidor, LocalDate.parse(validade, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}


	@Override
	public String formatar(Visitor visitor) {
		visitor.visitarRg(this);
		return this.getRgFormatado();
	}


	@Override
	public boolean validar(Visitor visitor) {
		this.aceitar(visitor);
		return this.isValido();
	}


	@Override
	public Integer pontuar(Visitor visitor) {
		this.aceitar(visitor);
		return this.getPontuacao();
	}


	public String getNome() {
		return nome;
	}


	public String getNumero() {
		return numero;
	}


	public String getExpedidor() {
		return expedidor;
	}


	public LocalDate getValidade() {
		return validade;
	}


	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitarRg(this);
	}
	
	
	public void setRgFormatado(String rgFormatado) {
		this.rgFormatado = rgFormatado;
	}

	private String getRgFormatado() {
		return this.rgFormatado;
	}


	public boolean isValido() {
		return isValido;
	}


	public void setValido(boolean isValido) {
		this.isValido = isValido;
	}


	public Integer getPontuacao() {
		return pontuacao;
	}


	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	
	
	

}
