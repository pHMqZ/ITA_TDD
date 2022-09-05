package com.pms.tdd.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pms.tdd.Armazenamento;
import com.pms.tdd.UsuarioComPontuacao;
import com.pms.tdd.UsuariosComPontos;

class TestArmazenamento {
	
	private Armazenamento armazenamento;
	private String nomeArquivo = "teste.txt";
	
	@BeforeEach
	public void inicio() throws Exception {
		armazenamento = new Armazenamento(nomeArquivo);
		File file = new File ("./" + nomeArquivo);
		if(file.exists()) {
			file.delete();
			file.createNewFile();
		} else {
			file.createNewFile();
		}
	}
	
	@AfterEach
	public void fim() throws IOException {
		File file = new File("./" + nomeArquivo);
		file.delete();
	}
	
	@Test
	public void registraPontosParaUsuario() throws IOException {
		String resposta = armazenamento.registraPontos("Alceu", "curtida", 15);
		assertEquals("O usuário Alceu recebeu 15 pontos do tipo curtida", resposta);
	}
	
	@Test
	public void recuperarPontosPorTipo() {
		String resposta = armazenamento.registraPontos("Alceu", "curtida", 15);
		int pontos = armazenamento.quantidadePontosPorTipos("Alceu", "curtida");
		assertEquals("O usuário Alceu recebeu 15 pontos do tipo curtida", resposta);
		assertEquals(15, pontos);
	}
	
	@Test
	public void recuperarQuantidadeDePontosDeDoisUsuarioPorTipoPontuacao() {
		String retornoRegistro;
		int pontosGuerra;
		int pontosClovis;
		
		retornoRegistro = armazenamento.registraPontos("Alceu", "estrela", 10);
		assertEquals("O usuário Alceu recebeu 10 pontos do tipo estrela", retornoRegistro);
		retornoRegistro = armazenamento.registraPontos("Elis", "estrela", 15);
		assertEquals("O usuário Elis recebeu 15 pontos do tipo estrela", retornoRegistro);
		
		pontosGuerra = armazenamento.quantidadePontosPorTipos("Alceu", "estrela");
		pontosClovis = armazenamento.quantidadePontosPorTipos("Elis", "estrela");
		assertEquals(10, pontosGuerra);
		assertEquals(15, pontosClovis);
	}
	
	@Test
	public void registrarTresUsuariosEVerificarUsuariosQuePossuemPontuacao() {
		armazenamento.registraPontos("Alceu", "moeda", 10);
		armazenamento.registraPontos("Elis", "moeda", 15);
		armazenamento.registraPontos("Banguela", "moeda", 15);
		
		String nomes = "";
		
		for (UsuarioComPontuacao usuario : armazenamento.getUsuariosComPontos().getUsuariosComPontuacao()) {
			nomes += usuario.getNomeUsuario() + ", ";
		}
		
		assertEquals("Alceu, Elis, Banguela, ", nomes);
	}
	
	@Test
	public void registrarCincoUsuariosEVerificarUsuariosQuePossuemPontuacao() {
		armazenamento.registraPontos("Alceu", "estrela", 10);
		armazenamento.registraPontos("Elis", "moeda", 15);
		armazenamento.registraPontos("Banguela", "moeda", 15);
		armazenamento.registraPontos("Phillip", "moeda", 20);
		armazenamento.registraPontos("João", "energia", 12);
		
		String nomes = "";
		
		for (UsuarioComPontuacao usuario : armazenamento.getUsuariosComPontos().getUsuariosComPontuacao()) {
			nomes += usuario.getNomeUsuario() + ", ";
		}
		
		assertEquals("Alceu, Elis, Banguela, Phillip, João, ", nomes);
	}
	
	@Test
	public void verificaTipoDePontoPorUsuario() {
		String tiposDePontos = "";

		armazenamento.registraPontos("Alceu", "estrela", 10);
		
		for (String tipo : armazenamento.getTiposDePontosPorUsuario("Alceu")) {
			tiposDePontos += tipo + ", ";
		}
		assertEquals("estrela, ", tiposDePontos);
	}
	
	@Test
	public void registrarDoisTiposDePontoParaOMesmoUsuario() {
		String tiposDePontos = "";

		armazenamento.registraPontos("Alceu", "estrela", 10);
		armazenamento.registraPontos("Alceu", "moeda", 20);
		
		for (String tipo : armazenamento.getTiposDePontosPorUsuario("Alceu")) {
			tiposDePontos += tipo + ", ";
		}
		assertEquals("estrela, moeda, ", tiposDePontos);
	}
	
	@Test
	public void registrarVariosTiposDePontoParaDoisUsuarios() {
		String tiposDePontosGuerra = "";
		String tiposDePontosClovis = "";

		armazenamento.registraPontos("Alceu", "estrela", 10);
		armazenamento.registraPontos("Alceu", "moeda", 20);

		armazenamento.registraPontos("Phillip", "energia", 10);
		armazenamento.registraPontos("Phillip", "curtida", 5);
		
		for (String tipo : armazenamento.getTiposDePontosPorUsuario("Alceu")) {
			tiposDePontosGuerra += tipo + ", ";
		}
		
		for (String tipo : armazenamento.getTiposDePontosPorUsuario("Phillip")) {
			tiposDePontosClovis += tipo + ", ";
		}
		
		assertEquals("estrela, moeda, ", tiposDePontosGuerra);
		assertEquals("energia, curtida, ", tiposDePontosClovis);
	}
	
	@Test
	public void arquivoEstaComOsValoresCorretosCadastradosAnteriormente() {
		armazenamento.registraPontos("Alceu", "estrela", 10);
		armazenamento.registraPontos("Alceu", "moeda", 20);
		armazenamento.registraPontos("Phillip", "energia", 10);
		armazenamento.registraPontos("Phillip", "curtida", 5);
		
		UsuariosComPontos usuariosCadastrados = armazenamento.getUsuariosComPontos();
		
		Armazenamento armazenamentoValidacao = new Armazenamento(nomeArquivo);
		
		UsuariosComPontos usuariosRecuperadosDoArquivo = armazenamentoValidacao.getUsuariosComPontos();
		
		assertEquals(usuariosCadastrados, usuariosRecuperadosDoArquivo);
	}
}
