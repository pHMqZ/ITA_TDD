package com.pms.tdd;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
	
	private List<Produto> itens = new ArrayList<>();
	
	public void adicionaProduto(Produto p) {
		itens.add(p);
	}
	
	public int total() {
		int total = 0;
		for( Produto p : itens)
			total += p.getValor();
		return total;
	}

	public void adicionarObservador(ObservadorCarrinho observador) {
		// TODO Auto-generated method stub
		
	}

}
