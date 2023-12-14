package br.edu.inf011.aval3.proxy;

import br.edu.inf011.aval3.enunciado.model.Perfil;
import br.edu.inf011.aval3.enunciado.model.service.Classificador;
import br.edu.inf011.aval3.enunciado.model.service.ClassificadorPerfil;
import br.edu.inf011.aval3.enunciado.model.service.NivelPerfil;

public class ClassificadorPerfilProxy implements Classificador {
	
	private ClassificadorPerfil classificadorPerfil;
	private boolean valido;

	@Override
	public NivelPerfil nivel() {
		if (!valido)
			return NivelPerfil.NAO_VERIFICADO;
		return this.classificadorPerfil.nivel();
	}

	@Override
	public Perfil getPerfil() {
		return this.classificadorPerfil.getPerfil();
	}
	
	private boolean validar(String user, String password) {
		if(!(classificadorPerfil.getPerfil().getUser().equals(user)) || !(classificadorPerfil.getPerfil().getPwd().equals(password))) {
			return false;
		}
		return true;
	}

	public ClassificadorPerfilProxy(ClassificadorPerfil classificadorPerfil, String user, String password) {
		this.classificadorPerfil = classificadorPerfil;
		this.valido = validar(user, password);
	}
}
