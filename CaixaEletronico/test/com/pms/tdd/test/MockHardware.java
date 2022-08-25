package com.pms.tdd.test;

import java.util.HashMap;
import java.util.Map;

import com.pms.tdd.Hardware;
import com.pms.tdd.exception.CartaoException;
import com.pms.tdd.exception.HardwareException;

public class MockHardware implements Hardware {
	
	private Map<String, String> vinculoCartaoConta = new HashMap();
	private boolean isCorrompido = false;
	
	
	public MockHardware() {
		vinculoCartaoConta.put("5230 0882 9140 4743", "57841");
		vinculoCartaoConta.put("5120 5494 8850 9647", "23314");
	}
	
	
	@Override
	public String pegarNumeroDaConta(String numeroCartao) throws HardwareException ,CartaoException{
		if(isCorrompido)
			throw new HardwareException("Erro de leitura");
		if(vinculoCartaoConta.containsKey(numeroCartao))
			return vinculoCartaoConta.get(numeroCartao);
		throw new CartaoException("Cart�o Inv�lido");
	}

	@Override
	public void entregarDinheiro() throws HardwareException {
		if(isCorrompido)
			throw new HardwareException("N�o foi poss�vel entregar o dinheiro");
	}

	@Override
	public void lerEnvelope() throws HardwareException {
		if(isCorrompido)
			throw new HardwareException("N�o foi poss�vel pegar o envelope");
	}

}
