package br.edu.inf011.aval3.visitor;

import br.edu.inf011.aval3.enunciado.model.CPF;
import br.edu.inf011.aval3.enunciado.model.CartaoCredito;
import br.edu.inf011.aval3.enunciado.model.EMail;
import br.edu.inf011.aval3.enunciado.model.RG;

public interface Visitor {
	
	 public void visitarCartaoCredito(CartaoCredito cartao);
	 public void visitarCpf(CPF cpf);
	 public void visitarEmail(EMail email);
	 public void visitarRg(RG rg);

}
