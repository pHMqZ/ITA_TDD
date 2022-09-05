package com.pms.tdd.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pms.tdd.Placar;
import com.pms.tdd.UsuarioComPontuacao;

class TestPlacar {

	private String nomeDoArquivo = "test.txt";
	private ArmazenamentoMock mock;
	private Placar placar;
	
	@BeforeEach
	void inicia() throws Exception {
		mock = new ArmazenamentoMock(nomeDoArquivo);
		placar = new Placar(mock);
	}
	
	@Test
	void registraUmTipoDePontoParaUmUsuario() {
		String retorno = placar.registrarPontos("Alceu", "curtida", 15);
		assertEquals("O usuário Alceu recebeu 15 pontos do tipo curtida", retorno);
	}
	
	@Test
	public void registrarUmTipoDePontoParaDoisUsuarios() {
		String retorno = placar.registrarPontos("Alceu", "curtida", 15);
		assertEquals("O usuário Alceu recebeu 15 pontos do tipo curtida", retorno);

		String retorno2 = placar.registrarPontos("Elis", "curtida", 20);
		assertEquals("O usuário Elis recebeu 20 pontos do tipo curtida", retorno2);
	}
	
	@Test
	public void verificarTodosOsPontosDeUmUsuario() {
		String[] resultado = new String[3];
		int i = 0;
		
		placar.registrarPontos("Alceu", "estrela", 10);
		placar.registrarPontos("Alceu", "curtida", 25);
		placar.registrarPontos("Alceu", "energia", 30);
		
		for (String result : placar.getTodosPontosPorUsuario("Alceu")) {
			resultado[i] = result;
			i++;
		}
		
		assertEquals("estrela - 10", resultado[0]);
		assertEquals("curtida - 25", resultado[1]);
		assertEquals("energia - 30", resultado[2]);
	}
	
	@Test
	public void verificaRankingPorTipoDePonto() {
		List<UsuarioComPontuacao> list = new ArrayList<>();
		
		list.add(new UsuarioComPontuacao("Alceu", "estrela", 30));
		list.add(new UsuarioComPontuacao("Elis", "estrela", 15));
		list.add(new UsuarioComPontuacao("Banguela", "estrela", 10));
		list.add(new UsuarioComPontuacao("Phillip", "estrela", 5));
		
		placar.registrarPontos("Banguela", "estrela", 10);
		placar.registrarPontos("Phillip", "estrela", 5);
		placar.registrarPontos("Alceu", "estrela", 30);
		placar.registrarPontos("Elis", "estrela", 15);
		
		List<UsuarioComPontuacao> ranking = placar.getRankingDeUsuarios("estrela");
		
		assertEquals(list, ranking);
	}
}
