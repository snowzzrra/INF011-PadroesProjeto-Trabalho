package br.edu.inf011.aval3.visitor;

import br.edu.inf011.aval3.enunciado.model.CPF;
import br.edu.inf011.aval3.enunciado.model.CartaoCredito;
import br.edu.inf011.aval3.enunciado.model.EMail;
import br.edu.inf011.aval3.enunciado.model.RG;

public class VisitorPontuar implements Visitor {

	@Override
	public void visitarCartaoCredito(CartaoCredito cartao) {
		VisitorValidar visitorValidar = new VisitorValidar();
		cartao.setPontuacao(cartao.validar(visitorValidar) ? 2 : 0);
	}

	@Override
	public void visitarCpf(CPF cpf) {
		cpf.setPontuacao(3);
	}

	@Override
	public void visitarEmail(EMail email) {		
		VisitorValidar visitorValidar = new VisitorValidar();
		email.setPontuacao(email.validar(visitorValidar) ? 1 : 0);
	}

	@Override
	public void visitarRg(RG rg) {
		VisitorValidar visitorValidar = new VisitorValidar();
		rg.setPontuacao(rg.validar(visitorValidar) ? 1 : 0);
	}

}
