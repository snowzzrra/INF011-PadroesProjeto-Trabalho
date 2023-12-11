package br.edu.inf011.aval3.visitor;

import java.time.LocalDate;
import java.util.regex.Pattern;

import br.edu.inf011.aval3.enunciado.model.CPF;
import br.edu.inf011.aval3.enunciado.model.CartaoCredito;
import br.edu.inf011.aval3.enunciado.model.EMail;
import br.edu.inf011.aval3.enunciado.model.RG;

public class VisitorValidar implements Visitor {

	@Override
	public void visitarCartaoCredito(CartaoCredito cartao) {
		cartao.getNumero().replace(" ", "");
		cartao.setValido(this.verificaLuhn(cartao) && cartao.getVencimento().isAfter(LocalDate.now()));
		
	}

	@Override
	public void visitarCpf(CPF cpf) {
		cpf.getNumero().replace(".", "");
		cpf.getNumero().replace("-", "");
		cpf.setValido(this.numeroValido(cpf));
	}

	@Override
	public void visitarEmail(EMail email) {
		email.setValido(
							Pattern.compile(EMail.REGEX)
							.matcher(email.getConta())
							.matches()
	    	      		);
	}

	@Override
	public void visitarRg(RG rg) {
		rg.setValido(rg.getValidade().isAfter(LocalDate.now()));
	}
	
	private boolean verificaLuhn(CartaoCredito cartao) {
		int sum = 0;
		boolean shouldDouble = false;
		for (int iCont = cartao.getNumero().length() - 1; iCont >= 0; iCont--) {
			int digit = cartao.getNumero().charAt(iCont) - '0';
		    if (shouldDouble) {
		      if ((digit *= 2) > 9) digit -= 9;
		    }
		    sum += digit;
		    shouldDouble = !shouldDouble;
		  }
		  return (sum % 10) == 0;		
	}
	
	
	private boolean numeroValido(CPF cpf) {
	    int d1, d2;
	    int digito1, digito2, resto;
	    String nDigResult;

	    d1 = d2 = 0;
	    digito1 = digito2 = resto = 0;

	    for (int iCount = cpf.getNumero().length() - 1, mult = 2; iCount >= 0; iCount--, mult++) {
	      int digitoCPF = cpf.getNumero().charAt(iCount) - '0';
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

	    String nDigVerific = cpf.getNumero().substring(cpf.getNumero().length() - 2, cpf.getNumero().length());
	    nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
	    return nDigVerific.equals(nDigResult);
	  
	}


}
