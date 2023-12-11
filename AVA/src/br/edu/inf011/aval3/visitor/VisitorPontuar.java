package br.edu.inf011.aval3.visitor;

import br.edu.inf011.aval3.enunciado.model.CPF;
import br.edu.inf011.aval3.enunciado.model.CartaoCredito;
import br.edu.inf011.aval3.enunciado.model.EMail;
import br.edu.inf011.aval3.enunciado.model.RG;

public class VisitorPontuar implements Visitor {

	@Override
	public void visitarCartaoCredito(CartaoCredito cartao) {
		VisitorValidar visitorValidar = new VisitorValidar();
		//return this.validar() ? 2 : 0;  original é esse aqui
		
		//cartao.aceitar(visitorValidar) ? 2 : 0;
	}

	@Override
	public void visitarCpf(CPF cpf) {
		//return 3;
	}

	@Override
	public void visitarEmail(EMail email) {
		
		VisitorValidar visitorValidar = new VisitorValidar();
		//email.aceitar(visitorValidar) ? 1 : 0;
		
		
		//return this.validar() ? 1 : 0;  original

	}

	@Override
	public void visitarRg(RG rg) {
		
		VisitorValidar visitorValidar = new VisitorValidar();
		rg.aceitar(visitorValidar);
		
		
		//return this.validar() ? 1 : 0;   original

	}

}
