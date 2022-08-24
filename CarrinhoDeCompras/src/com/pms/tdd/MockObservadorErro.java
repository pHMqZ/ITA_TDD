package com.pms.tdd;

public class MockObservadorErro implements ObservadorCarrinho {

	@Override
	public void produtoAdicionado(String nome, int valor) {
		throw new RuntimeException("Problema simulado no mock");
	}

}
