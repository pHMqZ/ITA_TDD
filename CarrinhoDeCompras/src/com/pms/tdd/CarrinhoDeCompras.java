package com.pms.tdd;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
	
	private List<Produto> itens = new ArrayList<>();
	private List<ObservadorCarrinho> observadores = new ArrayList<>();
	
	public void adicionaProduto(Produto p) {
		itens.add(p);
		for(ObservadorCarrinho observador : observadores)
			observador.produtoAdicionado(p.getNome(), p.getValor());
	}
	
	public int total() {
		int total = 0;
		for( Produto p : itens)
			total += p.getValor();
		return total;
	}

	public void adicionarObservador(ObservadorCarrinho observador) {
		observadores.add(observador);
	}

}
