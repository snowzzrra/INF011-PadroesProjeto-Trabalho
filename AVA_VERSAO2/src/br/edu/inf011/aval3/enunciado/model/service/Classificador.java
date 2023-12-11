package br.edu.inf011.aval3.enunciado.model.service;

import br.edu.inf011.aval3.enunciado.model.Perfil;

public interface Classificador {
	
	public NivelPerfil nivel(String user, String password);
	public Perfil getPerfil();
	
}
