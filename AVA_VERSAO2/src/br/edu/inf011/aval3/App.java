package br.edu.inf011.aval3;

import br.edu.inf011.aval3.builder.UsuarioBuilder;
import br.edu.inf011.aval3.enunciado.model.CPF;
import br.edu.inf011.aval3.enunciado.model.Perfil;

public class App {
	
	
	public static void main(String[] args) {
		
		UsuarioBuilder ub = new UsuarioBuilder();
		ub.setNome("Yuri");
		ub.setPassword("Minha senha");
		CPF cpf = new CPF("Yuri", "987.654.321-00");
		ub.addCpf(cpf);
		
		CPF cpf2 = new CPF("Roberto", "12345678909");
		ub.addCpf(cpf2);
		Perfil perfil = ub.get();
		System.out.println("CHEGUEI AQUI");
		
		System.out.println(perfil.toString());
		System.out.println("Pwd: " + perfil.getPwd());
		System.out.println(perfil.getUser());
		
		
		
		
	}
	
	


}
