package com.pms.tdd;

import java.util.ArrayList;
import java.util.List;

public class Placar {
	
	private Armazenamento save;
	
	public Placar(Armazenamento save) {
		super();
		this.save = save;
	}
	
	public String registrarPontos(String nomeUsuario, String tipoPonto, int pontos) {
		return save.registraPontos(nomeUsuario, tipoPonto, pontos);
	}
	
	public List<String> getTodosPontosPorUsuario(String nomeUsuario) {
		
		List<String> pontuacoes = new ArrayList<>();
		
		UsuariosComPontos users = save.getUsuariosComPontos();
		
		for(UsuarioComPontuacao user : users.getUsuariosComPontuacao()) {
			if(nomeUsuario.equals(user.getNomeUsuario()))
				pontuacoes.add(user.getTipoPonto() + " - " +user.getPontos());
		}
		
		return pontuacoes;
	}
	
	public List<UsuarioComPontuacao> getRankingDeUsuarios(String string){
		return save.getUsuariosComPontos().getListaOrdenadaDeUsuariosComPontuacao();
	}

}
