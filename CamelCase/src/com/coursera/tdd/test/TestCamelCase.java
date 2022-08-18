package com.coursera.tdd.test;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.coursera.tdd.CamelCase;
import com.coursera.tdd.ConvertException;

class TestCamelCase {

	@Test
	public void camelCaseUmaPalavra() throws ConvertException {
		List<String> expected = Arrays.asList("nome");
		List<String> result= CamelCase.convertCamelCase("nome");
		assertEquals(expected, result);
	}
	
	
	@Test
	public void camelCaseLetraMaiuscula() throws ConvertException {
		List<String> expected = Arrays.asList("nome");
		List<String> result = CamelCase.convertCamelCase("Nome");
		assertEquals(expected, result);
	}
	
	@Test
	public void camelCasePalavraComposta() throws ConvertException {
		List<String> expected = Arrays.asList("nome", "composto");
		List<String> result = CamelCase.convertCamelCase("NomeComposto");
		assertEquals(expected, result);
	}
	
	@Test
	public void camelCaseSiglas() throws ConvertException {
		List<String> expected = Arrays.asList("CPF");
		List<String> result = CamelCase.convertCamelCase("CPF");
		assertEquals(expected, result);
	}
	
	@Test
	public void camelCasePalavraComNumero() throws ConvertException {
		List<String> expected = Arrays.asList("recupera","10", "primeiros");
		List<String> result = CamelCase.convertCamelCase("recupera10Primeiros");
		assertEquals(expected, result);
	}
	
	@Test
	public void camelCasePalavraComCaractereEspecial() throws ConvertException {
		assertThrows(ConvertException.class, () ->{
			CamelCase.convertCamelCase("nome#composto");
		});
	}
	
	@Test
	public void camelCasePalavraComeçandoComNumero() throws ConvertException {
		assertThrows(ConvertException.class, () -> {
			CamelCase.convertCamelCase("10Primeiros");
		});
	}
}
