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
			return "Não foi possível autenticar o usuário";
		return "Usuário autenticado";
	}

	public String depositar(Integer valorDepositado) throws ContaException {
		if (clog == null)
			throw new ContaException("Usuário não logado");
		hw.lerEnvelope();
		clog.deposito(valorDepositado);
		sr.persistirConta(clog);
		return "Depósito realizado com sucesso";
	}

	public String sacar(double valorSacado) {
		if (clog == null)
			throw new ContaException("Usuário não logado");
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
			throw new ContaException("Usuário não logado");
		return "O saldo é R$ "+clog.getSaldo();
	}
}
