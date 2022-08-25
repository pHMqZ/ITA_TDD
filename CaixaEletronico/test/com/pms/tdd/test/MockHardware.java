package com.pms.tdd.test;

import java.util.HashMap;
import java.util.Map;

import com.pms.tdd.Hardware;
import com.pms.tdd.exception.CartaoException;
import com.pms.tdd.exception.HardwareException;

public class MockHardware implements Hardware {
	
	private boolean entregaDinheiro = false;
	private boolean leituraEnvelope = false;
	
	public void erroEntregaDinheiro() {
		entregaDinheiro = true;
	}
	
	public void erroLeituraEnvelope() {
		leituraEnvelope = true;
	}
	
	@Override
	public String pegarNumeroDaConta(String conta) throws HardwareException ,CartaoException{
		if(conta.equals("0"))
			return "Erro no cartão, tente novamente";
		if(conta.equals("x"))
			return "Cartão invalido";
		return conta;
	}

	@Override
	public void entregarDinheiro() throws HardwareException {
		if (entregaDinheiro)
			throw new HardwareException("Problema na entrega do dinheiro");
	}

	@Override
	public void lerEnvelope() throws HardwareException {
		if (leituraEnvelope)
			throw new HardwareException("Problema ao ler o envelope");
	}

}
