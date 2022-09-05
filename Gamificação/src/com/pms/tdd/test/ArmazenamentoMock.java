package com.pms.tdd.test;

import java.io.IOException;

import com.pms.tdd.Armazenamento;
import com.pms.tdd.UsuarioComPontuacao;
import com.pms.tdd.UsuariosComPontos;

public class ArmazenamentoMock extends Armazenamento{
	
	private UsuariosComPontos users = new UsuariosComPontos();

	public ArmazenamentoMock(String nomeArquivo) {
		super(nomeArquivo);
	}
	
	@Override
	public String registraPontos(String nomeUsuario, String tipoPonto, int pontos) {
		users.adicionaUsuarioComPontuacao(new UsuarioComPontuacao(nomeUsuario, tipoPonto, pontos));
		return "O usuário " + nomeUsuario + " recebeu " + pontos + " pontos do tipo " + tipoPonto;
	}

	@Override
	public UsuariosComPontos getUsuariosComPontos() {
		return users;
	}

	@Override
	protected void escreverArquivo (UsuarioComPontuacao usuario) {
		
	}

	@Override
	protected void lerArquivo() throws IOException {
		
	}

}
