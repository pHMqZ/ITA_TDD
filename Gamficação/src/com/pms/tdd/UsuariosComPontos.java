package com.pms.tdd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UsuariosComPontos {

	private List<UsuarioComPontuacao> usuariosComPontos;
	
	public UsuariosComPontos() {
		super();
		this.usuariosComPontos = new ArrayList<>();
	}
	
	public void adicionaUsuarioComPontuacao(UsuarioComPontuacao usuario) {
		usuariosComPontos.add(usuario);
	}
	
	public List<UsuarioComPontuacao> getUsuariosComPontuacao() {
		return new ArrayList<>(usuariosComPontos);
	}
	
	public int getPontuacaoPorNomeUsuarioETipoPontuacao(String nomeUsuario, String tipoPontuacao) {
		
		int pontuacao = 0;
		
		for (UsuarioComPontuacao usuarioComPontuacao : usuariosComPontos) {
			if (nomeUsuario.equals(usuarioComPontuacao.getNomeUsuario()) && tipoPontuacao.equals(usuarioComPontuacao.getTipoPonto()))
				pontuacao = usuarioComPontuacao.getPontos();
		}
		
		return pontuacao;
	}
	
	public List<UsuarioComPontuacao> getListaOrdenadaDeUsuariosComPontuacao() {
		List<UsuarioComPontuacao> usuarios = new ArrayList<>(this.usuariosComPontos);
		Comparator<UsuarioComPontuacao> comparator = (u1, u2) -> u1.getPontos() - u2.getPontos();
		usuarios.sort(comparator.reversed());
		
		return usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuariosComPontos == null) ? 0 : usuariosComPontos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuariosComPontos other = (UsuariosComPontos) obj;
		if (usuariosComPontos == null) {
			if (other.usuariosComPontos != null)
				return false;
		} else if (!usuariosComPontos.equals(other.usuariosComPontos))
			return false;
		return true;
	}
	
}
