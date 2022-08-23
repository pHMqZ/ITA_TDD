package com.pms.tdd;

import static org.junit.jupiter.api.Assertions.*;

public class MockObservadorCarrinho implements ObservadorCarrinho {
	
	private String nomeRecebido;
	private int valorRecebido;

	@Override
	public void produtoAdicionado(String nome, int valor) {
		nomeRecebido = nome;
		valorRecebido = valor;
	}

	public void verificaRecebimentoProduto(String nomeEsperado, int valorEsperado) {
		assertEquals(nomeEsperado, nomeRecebido);
		assertEquals(valorEsperado, valorRecebido);
	}

}
