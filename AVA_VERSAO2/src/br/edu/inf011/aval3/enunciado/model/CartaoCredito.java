package br.edu.inf011.aval3.enunciado.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.edu.inf011.aval3.visitor.Visitor;
import br.edu.inf011.aval3.visitor.VisitorValidar;

public class CartaoCredito implements Documento{
	private String nome;
	private String numero;	
	private String cvc;
	private LocalDate vencimento;
	
	
	//Atributo novo
	private String cartaoCreditoFormatado;
	private boolean isValido;
	private Integer pontuacao;
	
	public CartaoCredito(String nome, String numero, String cvc, LocalDate vencimento) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.cvc = cvc;
		this.vencimento = vencimento;
		this.cartaoCreditoFormatado = null;
		this.isValido = false;
		this.pontuacao = null;
	}
	
	public CartaoCredito(String nome, String numero, String cvc, String vencimento) {
		this(nome, numero, cvc, LocalDate.parse(vencimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}	
	
	public String formatar(Visitor visitor) {
		this.aceitar(visitor);
		return this.getCartaoCreditoFormatado();
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
	
//	private boolean verificaLuhn() {
//		int sum = 0;
//		boolean shouldDouble = false;
//		for (int iCont = this.numero.length() - 1; iCont >= 0; iCont--) {
//			int digit = this.numero.charAt(iCont) - '0';
//		    if (shouldDouble) {
//		      if ((digit *= 2) > 9) digit -= 9;
//		    }
//		    sum += digit;
//		    shouldDouble = !shouldDouble;
//		  }
//		  return (sum % 10) == 0;		
//	}

	public String getNome() {
		return nome;
	}

	public String getNumero() {
		return numero;
	}

	public String getCvc() {
		return cvc;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}


	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitarCartaoCredito(this);
	}

	public String getCartaoCreditoFormatado() {
		return cartaoCreditoFormatado;
	}

	public void setCartaoCreditoFormatado(String cartaoCreditoFormatado) {
		this.cartaoCreditoFormatado = cartaoCreditoFormatado;
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

