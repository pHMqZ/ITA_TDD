package com.pms.tdd.test;

import java.util.ArrayList;
import java.util.List;

import com.pms.tdd.ContaCorrente;
import com.pms.tdd.ServicoRemoto;
import com.pms.tdd.exception.ContaException;

public class MockServicoRemoto implements ServicoRemoto {
	
	private List<ContaCorrente> contas = new ArrayList<>();
	
	public MockServicoRemoto() {
		contas.add(new ContaCorrente(57841));
		contas.add(new ContaCorrente(23314));
	}

	@Override
	public ContaCorrente recuperarConta(int conta, Double saldo) throws ContaException{
		for (ContaCorrente cc : contas) {
			if(cc.getConta() == conta) {
				 ContaCorrente ccInfo = new ContaCorrente(cc.getConta(), cc.getSaldo());
					 return ccInfo;
				 
			}
		}
		throw new ContaException("Dados inválidos");
	}

	@Override
	public void persistirConta(ContaCorrente cc) {
		contas.set(contas.indexOf(cc), cc);

	}

}
