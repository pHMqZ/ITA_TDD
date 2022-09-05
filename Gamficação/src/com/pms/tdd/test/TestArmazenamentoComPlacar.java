package com.pms.tdd.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pms.tdd.Armazenamento;
import com.pms.tdd.Placar;
import com.pms.tdd.UsuarioComPontuacao;

class TestArmazenamentoComPlacar {

	private Armazenamento save;
	private Placar placar;
	private String nomeDoArquivo = "teste.txt";
	private List<UsuarioComPontuacao> usuarios;

	@BeforeEach
	public void inicia() throws Exception {
		save = new Armazenamento(nomeDoArquivo);
		placar = new Placar(save);

		File file = new File("./" + nomeDoArquivo);
		if (file.exists()) {
			file.delete();
			file.createNewFile();
		} else {
			file.createNewFile();
		}

		usuarios = new ArrayList<>();
		
		usuarios.add(new UsuarioComPontuacao("Elis", "estrela", 35));
		usuarios.add(new UsuarioComPontuacao("Bexiga", "estrela", 25));
		usuarios.add(new UsuarioComPontuacao("Alceu", "estrela", 15));
		usuarios.add(new UsuarioComPontuacao("Banguela", "estrela", 10));
		usuarios.add(new UsuarioComPontuacao("Phillip", "estrela", 5));
	}
	
	@AfterEach
	void finaliza() throws IOException {
		File file = new File("./" + nomeDoArquivo);
		file.delete();
	}
	
	@Test
	void registraUmTipoDePontoParaUmUsuario() {
		String retorno = placar.registrarPontos("Alceu", "estrela", 20);
		assertEquals("O usuário Alceu recebeu 20 pontos do tipo estrela", retorno);
	}
	
	@Test
	void registroUmPontoParaDoisUsuarios() {
		String retorno = placar.registrarPontos("Alceu", "estrela", 20);
		String retorno2 = placar.registrarPontos("Elis", "estrela", 25);
		
		assertEquals("O usuário Alceu recebeu 20 pontos do tipo estrela", retorno);
		assertEquals("O usuário Elis recebeu 25 pontos do tipo estrela", retorno2);
	}
	
	@Test
	void verificaTodosPontosDeUmUsuario() {
		String [] result = new String [2];
		int i = 0;
		
		placar.registrarPontos("Alceu", "estrela", 15);
		placar.registrarPontos("Alceu", "curtida", 10);
		
		for(String list : placar.getTodosPontosPorUsuario("Alceu")) {
			result[i] = list;
			i++;
		}
		
		assertEquals("estrela - 15", result[0]);
		assertEquals("curtida - 10", result[1]);
	}
	
	
	@Test
	void verificaRankingPorTipoDePonto() {
		placar.registrarPontos("Elis", "estrela", 35);
		placar.registrarPontos("Bexiga", "estrela", 25);
		placar.registrarPontos("Alceu", "estrela", 15);
		placar.registrarPontos("Banguela", "estrela", 10);
		placar.registrarPontos("Phillip", "estrela", 5);
		
		List<UsuarioComPontuacao> ranking = placar.getRankingDeUsuarios("estrela");
		
		assertEquals(usuarios, ranking);
	}

	@Test
	void verificaRankingSalvoAntes() {
		placar.registrarPontos("Elis", "estrela", 35);
		placar.registrarPontos("Bexiga", "estrela", 25);
		placar.registrarPontos("Alceu", "estrela", 15);
		placar.registrarPontos("Banguela", "estrela", 10);
		placar.registrarPontos("Phillip", "estrela", 5);
		
		Armazenamento validacao = new Armazenamento(nomeDoArquivo);
		Placar pValidacao = new Placar(validacao);
		
		List<UsuarioComPontuacao> ranking = pValidacao.getRankingDeUsuarios("estrela");
		
		assertEquals(usuarios,ranking);
	}
}
