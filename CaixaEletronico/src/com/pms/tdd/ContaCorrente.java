package com.pms.tdd;

public class ContaCorrente {
	
	private String conta;
	private Double saldo = 0.0;
	

	public ContaCorrente(String conta, double saldo) {
		this.conta = conta;
		this.saldo= saldo;
	}

	public String getConta() {
		return conta;
	}

	public Double getSaldo() {
		return saldo;
	}

//	public void setSaldo(Double saldo) {
//		this.saldo = saldo;
//	}
	
	public Double sacar(double valorSacado) {
		return saldo -= valorSacado;
	}
	
	public Double deposito(double valorDepositado) {
		return saldo += valorDepositado;
	}
	
}
