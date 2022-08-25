package com.pms.tdd.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pms.tdd.CaixaEletronico;

class TestCaixaEletronico {

	private CaixaEletronico ce;
	
	@BeforeEach
	public void criarNovoCaixa(){
		ce = new CaixaEletronico(new MockHardware(), new MockServicoRemoto());
	}
	
	@Test
	public void logarUsuarioComSucesso() {
		assertEquals("Usuário autenticado", ce.logar("57841"));
	}
	
	@Test
	public void logarUsuarioInvalido() {
		assertEquals("Não foi possível autenticar o usuário", ce.logar("5231"));
	}
	
	@Test
	public void logarERealizarDeposito() {
		assertEquals("Usuário autenticado", ce.logar("57841"));
		assertEquals("Depósito realizado com sucesso", ce.depositar(100));
		
	}
	
}
