package com.pms.tdd.test;

import java.util.HashMap;

import com.pms.tdd.ContaCorrente;
import com.pms.tdd.ServicoRemoto;

public class MockServicoRemoto implements ServicoRemoto {
	
	private HashMap<String, Double> contas = new HashMap<>(); 
	
	public MockServicoRemoto() {
		contas.put("57841", 0.0);
		contas.put("23314", 500.0);
	}

	@Override
	public ContaCorrente recuperarConta(String conta) {
		if(contas.containsKey(conta))
			return new ContaCorrente(conta, contas.get(conta));
		return null;
	}

	@Override
	public void persistirConta(ContaCorrente conta) {
		if(contas.containsKey(conta.getConta()))
			contas.replace(conta.getConta(),conta.getSaldo());
	}
	
	
}
