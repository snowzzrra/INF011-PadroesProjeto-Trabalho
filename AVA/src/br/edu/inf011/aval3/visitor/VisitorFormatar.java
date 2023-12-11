package br.edu.inf011.aval3.visitor;

import java.time.format.DateTimeFormatter;

import br.edu.inf011.aval3.enunciado.model.CPF;
import br.edu.inf011.aval3.enunciado.model.CartaoCredito;
import br.edu.inf011.aval3.enunciado.model.EMail;
import br.edu.inf011.aval3.enunciado.model.RG;

public class VisitorFormatar implements Visitor {

	@Override
	public void visitarCartaoCredito(CartaoCredito cartao) {
		StringBuilder fmt = new StringBuilder();
		fmt.append("CARTÃO DE CRÉDITO\n");
		fmt.append(cartao.getNome() + "\n");
		fmt.append(cartao.getNumero().substring(0, 4) + " ");
		fmt.append(cartao.getNumero().substring(4, 8) + " ");
		fmt.append(cartao.getNumero().substring(8, 12) + " ");
		fmt.append(cartao.getNumero().substring(12, 16) + "\n");
		fmt.append(cartao.getCvc() + "\n");
		fmt.append(cartao.getVencimento().format(DateTimeFormatter.ofPattern("MM/yy")));
		//return fmt.toString();
	}

	@Override
	public void visitarCpf(CPF cpf) {
		StringBuilder fmt = new StringBuilder();
		fmt.append("CPF\n");
		fmt.append(cpf.getNome()+ " - ");
		fmt.append(cpf.getNumero().substring(0, 3) + "." + 
				cpf.getNumero().substring(3, 6) + "." +
				cpf.getNumero().substring(6, 9) + "-" + 
				cpf.getNumero().substring(9, 11));
		//return fmt.toString();
	}

	@Override
	public void visitarEmail(EMail email) {
		 String format = "E-MAIL\n" + email.getConta();
		 System.out.println(format);
	}

	@Override
	public void visitarRg(RG rg) {

		StringBuilder fmt = new StringBuilder();
		fmt.append("RG\n");
		fmt.append(rg.getNome() + "\n");
		fmt.append(rg.getNumero().substring(0, rg.getNumero().length() - 2) + "-");
		fmt.append(rg.getNumero().substring(rg.getNumero().length() - 2, rg.getNumero().length()) + " - ");
		fmt.append(rg.getExpedidor() + "\n");
		fmt.append("Validade: " + rg.getValidade().format(DateTimeFormatter.ofPattern("dd/MM/yy")));
		//return fmt.toString();
	}

}
