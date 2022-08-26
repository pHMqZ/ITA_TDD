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
		assertEquals("Usu�rio autenticado", ce.logar("57841"));
	}
	
	@Test
	public void logarUsuarioInvalido() {
		assertEquals("N�o foi poss�vel autenticar o usu�rio", ce.logar("5231"));
	}
	
	@Test
	public void logarERealizarDeposito() {
		assertEquals("Usu�rio autenticado", ce.logar("57841"));
		assertEquals("Dep�sito realizado com sucesso", ce.depositar(100));
		
	}
	
	@Test
	public void logarERealizarSaque() {
		assertEquals("Usu�rio autenticado", ce.logar("23314"));
		assertEquals("Retire o dinheiro", ce.sacar(100));
	}
	
	@Test
	public void realizarSaqueComErro() {
		ce.logar("57841");
		assertEquals("Saldo insuficiente", ce.sacar(100));
	}
	
	@Test
	public void visualizaSaldo() {
		ce.logar("23314");
		assertEquals("O saldo � R$ "+500.0,ce.saldo());
	}
}
