package br.edu.inf011.aval3.proxy;

import br.edu.inf011.aval3.enunciado.model.Perfil;
import br.edu.inf011.aval3.enunciado.model.service.Classificador;
import br.edu.inf011.aval3.enunciado.model.service.ClassificadorPerfil;
import br.edu.inf011.aval3.enunciado.model.service.NivelPerfil;

public class ClassificadorPerfilProxy implements Classificador {
	
	
	private ClassificadorPerfil classificadorPerfil;

	@Override
	public NivelPerfil nivel() {
		this.validar(null, null); //Chamar aqui para verificar se as credenciais estão corretas.
		return null;
	}

	@Override
	public Perfil getPerfil() {
		return null;
	}
	
	private boolean validar(String user, String password) {
		if(!(classificadorPerfil.getPerfil().getUser().equals(user)) || !(classificadorPerfil.getPerfil().getPwd().equals(password))) {
			return false;
		}
		return true;
	}

}
