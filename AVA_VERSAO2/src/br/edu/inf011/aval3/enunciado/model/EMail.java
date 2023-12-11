package br.edu.inf011.aval3.enunciado.model;

import java.util.regex.Pattern;

import br.edu.inf011.aval3.visitor.Visitor;
import br.edu.inf011.aval3.visitor.VisitorValidar;

public class EMail implements Documento{
	
	public static final String REGEX = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$"; 
	
	private String conta;
	
	//Atributos novos
	private String emailFormatado;
	private boolean isValido;
	private Integer  pontuacao;
	

	public EMail(String conta) {
		super();
		this.conta = conta;
		this.emailFormatado = null;
	}

	@Override
	public String formatar(Visitor visitor) {
		visitor.visitarEmail(this);
		return this.getEmailFormatado();
		
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

	public static String getRegex() {
		return REGEX;
	}

	public String getConta() {
		return conta;
	}

	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitarEmail(this);
		
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

	
	public String getEmailFormatado() {
		return emailFormatado;
	}

	public void setEmailFormatado(String emailFormatado) {
		this.emailFormatado = emailFormatado;
	}
	
	
	

}
