package com.pms.tdd;

import com.pms.tdd.exception.ContaException;

public class ContaCorrente {
	
	private int conta;
	private Double saldo = 0.0;
	
	public ContaCorrente(int conta) {
		if(conta <=0)
			throw new ContaException("Numero da conta inválido");
		this.conta = conta;
	}

	public ContaCorrente(int conta, double saldo) {
		if(conta <=0)
			throw new ContaException("Numero da conta inválido");
		this.conta = conta;
		this.saldo= saldo;
	}

	public int getConta() {
		return conta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double depositar(double valorDepositado) {
			return saldo += valorDepositado;
	}

	public Double sacar(double valorSacado) {
		if(valorSacado > saldo)
			throw new ContaException("Valor solicitado é maior que seu saldo atual");
		return saldo -= valorSacado;
	}
	
	

}
