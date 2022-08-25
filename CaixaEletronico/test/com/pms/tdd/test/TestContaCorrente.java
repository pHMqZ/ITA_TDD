package com.pms.tdd.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pms.tdd.CaixaEletronico;
import com.pms.tdd.ContaCorrente;
import com.pms.tdd.exception.ContaException;

class TestContaCorrente {
	
	private ContaCorrente cc;
	private CaixaEletronico ce;

	@BeforeEach
	public void criarNovaConta() {
		cc = new ContaCorrente(57841);
	}
	
	@BeforeEach
	public void criarNovoCaixa(){
		ce = new CaixaEletronico(new MockHardware(), new MockServicoRemoto());
	}
	
	@Test
	public void retornarNumeroConta() {
		assertEquals(57841, cc.getConta());
	}
	
	@Test
	public void retornarSaldoConta() {
		assertEquals(0.0, cc.getSaldo());
	}
	
	@Test
	public void NumeroContaInvalidoRetornaErro() {
		assertThrows(ContaException.class, () ->{
			new ContaCorrente(0);
		});
	}
	
	@Test
	public void depositarValorDaConta() {
		cc.depositar(400.00);
		assertEquals(400.0, cc.getSaldo());
	}
	
	@Test
	public void sacarValorDaContaMenorQueSaldo() {
		cc = new ContaCorrente(2314, 400.0);
		cc.sacar(100.00);
		assertEquals(300.0, cc.getSaldo());
	}
	
	@Test
	public void saqueSemSaldo() {
		cc = new ContaCorrente(2314, 400.0);
		assertThrows(ContaException.class, () ->{
			cc.sacar(1000.0);
		});
	}
	
	@Test
	public void logarUsuarioComSucesso() {
		assertEquals("Usuário autenticado", ce.login("4567 3321 7658 4344", 57841));
	}
}
