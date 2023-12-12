package br.edu.inf011.aval3.proxy;

import br.edu.inf011.aval3.enunciado.model.Perfil;
import br.edu.inf011.aval3.enunciado.model.service.Classificador;
import br.edu.inf011.aval3.enunciado.model.service.ClassificadorPerfil;
import br.edu.inf011.aval3.enunciado.model.service.NivelPerfil;

public class ClassificadorPerfilProxy implements Classificador{
	
	private ClassificadorPerfil classificadorPerfil;
	private Perfil perfil;

	
	public ClassificadorPerfilProxy(Perfil perfil) {
		
	}
	
	@Override
	public NivelPerfil nivel(String user, String password) {
		if(this.autenticar(user, password)) {
			return classificadorPerfil.nivel(user, password);
		}
		
		return null;
	}

	@Override
	public Perfil getPerfil() {
		return perfil;
	}
	
	private boolean autenticar(String usuario, String password) {
		if(!(this.getPerfil().getUser().equals(usuario)) || !(this.getPerfil().getPwd().equals(password))) {
			return false;
		}
		return true;
	}
	

}
