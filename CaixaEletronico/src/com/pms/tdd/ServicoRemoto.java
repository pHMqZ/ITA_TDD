package com.pms.tdd;

public interface ServicoRemoto {
	
	ContaCorrente recuperarConta(int conta, Double saldo);
	void persistirConta(ContaCorrente cc);

}
