package br.edu.inf011.aval3.enunciado.model;

import br.edu.inf011.aval3.visitor.Element;

public interface Documento extends Element{
	public String formatar();
	public boolean validar();
	public Integer pontuar();
	
}
