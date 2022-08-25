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

	public int getConta() {
		return conta;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	
	

}
