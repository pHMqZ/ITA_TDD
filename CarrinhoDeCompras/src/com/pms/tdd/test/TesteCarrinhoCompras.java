package com.pms.tdd.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pms.tdd.CarrinhoDeCompras;
import com.pms.tdd.MockObservadorCarrinho;
import com.pms.tdd.Produto;

class TesteCarrinhoCompras {
	
	private CarrinhoDeCompras c;
	
	@BeforeEach
	public void iniciaCarrinho() {
		c = new CarrinhoDeCompras();
	}

	@Test
	public void totalCarrinho() {
		c.adicionaProduto(new Produto("tenis", 100));
		c.adicionaProduto(new Produto("camiseta", 50));
		c.adicionaProduto(new Produto("bermuda", 70));
		assertEquals(220,c.total());
	}
	
	@Test
	public void estudaAdicaoDeProduto() {
		MockObservadorCarrinho mock = new MockObservadorCarrinho();
		c.adicionarObservador(mock);
		c.adicionaProduto(new Produto("tenis", 100));
		mock.verificaRecebimentoProduto("tenis",100);
	}

	@Test
	public void adicionarDoisObservadores() {
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
		c.adicionarObservador(mock1);
		c.adicionarObservador(mock2);
		c.adicionaProduto(new Produto("tenis", 100));
		mock1.verificaRecebimentoProduto("tenis", 100);
		mock2.verificaRecebimentoProduto("tenis", 100);
	}
}
