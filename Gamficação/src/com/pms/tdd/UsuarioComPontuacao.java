package com.pms.tdd;

public class UsuarioComPontuacao {
	
	private String nomeUsuario;
	private String tipoPonto;
	private int pontos;
	
	public UsuarioComPontuacao(String nomeUsuario, String tipoPonto, int pontos) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.tipoPonto = tipoPonto;
		this.pontos = pontos;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getTipoPonto() {
		return tipoPonto;
	}

	public int getPontos() {
		return pontos;
	}
	
	@Override
	public String toString() {
		return nomeUsuario + ";" + tipoPonto + ";" + pontos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		result = prime * result + pontos;
		result = prime * result + ((tipoPonto == null) ? 0 : tipoPonto.hashCode());
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
		UsuarioComPontuacao other = (UsuarioComPontuacao) obj;
		if (nomeUsuario == null) {
			if (other.nomeUsuario != null)
				return false;
		} else if (!nomeUsuario.equals(other.nomeUsuario))
			return false;
		if (pontos != other.pontos)
			return false;
		if (tipoPonto == null) {
			if (other.tipoPonto != null)
				return false;
		} else if (!tipoPonto.equals(other.tipoPonto))
			return false;
		return true;
	}
	

}
