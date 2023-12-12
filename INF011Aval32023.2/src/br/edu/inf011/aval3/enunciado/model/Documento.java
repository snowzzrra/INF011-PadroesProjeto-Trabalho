package br.edu.inf011.aval3.enunciado.model;

import br.edu.inf011.aval3.visitor.Visitor;

public interface Documento {
//	public String formatar();
//	public boolean validar();
//	public Integer pontuar();
	
	public Object aceitar(Visitor visitor);
}
