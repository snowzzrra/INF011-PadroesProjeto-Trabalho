package br.edu.inf011.aval3.enunciado.model;

import br.edu.inf011.aval3.visitor.Visitor;

public class CPF implements Documento{
	
	private String nome;
	private String numero;
	
	
	//Novos atributos
	private String cpfFormatado;
	private boolean isValido;
	private Integer pontuacao;
	

	public CPF(String nome, String numero) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.cpfFormatado = null;
	}


	@Override
	public String formatar(Visitor visitor) {
		this.aceitar(visitor);
		return this.getCpfFormatado();
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
	
	
	private boolean numeroValido() {
	    int d1, d2;
	    int digito1, digito2, resto;
	    String nDigResult;

	    d1 = d2 = 0;
	    digito1 = digito2 = resto = 0;

	    for (int iCount = this.numero.length() - 1, mult = 2; iCount >= 0; iCount--, mult++) {
	      int digitoCPF = this.numero.charAt(iCount) - '0';
	      d1 += (mult * digitoCPF);
	      d2 += ((mult - 1) * digitoCPF);
	    };

	    resto = (d1 % 11);

	    if (resto < 2)
	      digito1 = 0;
	    else
	      digito1 = 11 - resto;

	    d2 += 2 * digito1;
	    resto = (d2 % 11);

	    if (resto < 2)
	      digito2 = 0;
	    else
	      digito2 = 11 - resto;

	    String nDigVerific = this.numero.substring(this.numero.length() - 2, this.numero.length());
	    nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
	    return nDigVerific.equals(nDigResult);
	  
	}


	public String getNome() {
		return nome;
	}


	public String getNumero() {
		return numero;
	}


	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitarCpf(this);
	}


	public String getCpfFormatado() {
		return cpfFormatado;
	}


	public void setCpfFormatado(String cpfFormatado) {
		this.cpfFormatado = cpfFormatado;
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
