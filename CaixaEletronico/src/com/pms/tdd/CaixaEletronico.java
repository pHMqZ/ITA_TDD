package com.pms.tdd;

public class CaixaEletronico {
	
	private Hardware hw;
	private ServicoRemoto sr;

	public CaixaEletronico(Hardware hw, ServicoRemoto sr) {
		this.hw = hw;
		this.sr = sr;
	}
	
	public String logar(String numeroCartao, int conta) {
		int numConta = Integer.parseInt(hw.pegarNumeroDaConta(numeroCartao));
		ContaCorrente cc = sr.recuperarConta(numConta, 0.0);
		if(cc != null)
			return "Usuário autenticado";
		return null;
	}

}
