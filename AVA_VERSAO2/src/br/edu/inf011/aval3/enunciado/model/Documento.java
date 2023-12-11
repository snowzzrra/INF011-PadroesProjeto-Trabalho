package br.edu.inf011.aval3.enunciado.model;

import br.edu.inf011.aval3.visitor.Element;
import br.edu.inf011.aval3.visitor.Visitor;

public interface Documento extends Element{
	public String formatar(Visitor visitor);
	public boolean validar(Visitor visitor);
	public Integer pontuar(Visitor visitor);
	
}
