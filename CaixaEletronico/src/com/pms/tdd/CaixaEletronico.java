package com.pms.tdd;

import com.pms.tdd.exception.ContaException;

public class CaixaEletronico {

	private Hardware hw;
	private ServicoRemoto sr;
	private ContaCorrente clog;

	public CaixaEletronico(Hardware hw, ServicoRemoto sr) {
		this.hw = hw;
		this.sr = sr;
	}

	public String logar(String conta) {

		hw.pegarNumeroDaConta(conta);
		clog = sr.recuperarConta(conta);

		if (clog == null)
			return "N�o foi poss�vel autenticar o usu�rio";
		return "Usu�rio autenticado";
	}

	public String depositar(Integer valorDepositado) throws ContaException {
		if (clog == null)
			throw new ContaException("Usu�rio n�o logado");
		hw.lerEnvelope();
		clog.deposito(valorDepositado);
		sr.persistirConta(clog);
		return "Dep�sito realizado com sucesso";
	}

	public String sacar(double valorSacado) {
		if (clog == null)
			throw new ContaException("Usu�rio n�o logado");
		if (valorSacado <= clog.getSaldo()) {
			hw.entregarDinheiro();
			clog.sacar(valorSacado);
			sr.persistirConta(clog);
			return "Retire o dinheiro";
		} else {
			return "Saldo insuficiente";
		}
	}

	public String saldo() {
		if (clog == null)
			throw new ContaException("Usu�rio n�o logado");
		return "O saldo � R$ "+clog.getSaldo();
	}
}
