package com.pms.tdd;

public interface ServicoRemoto {
	
	ContaCorrente recuperarConta(String conta);
	void persistirConta(ContaCorrente conta);

}
