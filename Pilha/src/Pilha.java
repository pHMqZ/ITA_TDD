public class Pilha {
	
	private Object[] elementos;
	private int quantidade = 0;
	
	public Pilha(int maximo) {
		elementos = new Object[maximo];
	}

	public boolean estaVazia() {
		return quantidade == 0;
	}
	
	public boolean estaCheia() {
		return (this.quantidade == this.elementos.length);
	}

	public int tamanho() {
		return quantidade;
	}

	public void empilha(Object elemento) {
		if(this.estaCheia()) {
			throw new PilhaCheiaException("Não é possível empilhar, pilha cheia");
		}
		this.elementos[quantidade] = elemento;
		quantidade++;
		
	}

	public Object topo() {
		return elementos[quantidade -1];
	}

	public Object desempilha() {
		if(estaVazia()) {
			throw new PilhaVaziaException("Não é possível desempilhar, pilha vazia");
		}
		
		Object topo = topo();
		quantidade--;
		return topo;
	}

}
