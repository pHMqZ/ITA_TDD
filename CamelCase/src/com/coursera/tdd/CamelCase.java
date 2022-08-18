package com.coursera.tdd;

import java.util.Arrays;
import java.util.List;

public class CamelCase {

	public static List<String> convertCamelCase(String original) throws ConvertException {
		if(original.matches("^[0-9].*"))
			throw new ConvertException("Palavra não pode começar com números");
		if(!original.matches("(\\w)*"))
			throw new ConvertException("Palavra não pode conter caractere especial");
		List<String> texto = quebraPalavra(original); 
		return texto;
	}
	
	
	public static String minuscula(String palavra) {
		if(palavra.matches("^[A-Z][a-z].*"))
			palavra = palavra.substring(0,1).toLowerCase()+palavra.substring(1);
		return palavra;
	}
	
	
	public static List<String> quebraPalavra(String palavra){
		String palavras[] = palavra.split("(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|(?<!(^|[^0-9]))(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])");
		for(int i =0;i < palavras.length; i++) {
			palavras[i] = minuscula(palavras[i]);			
		}
		List<String> lista = Arrays.asList(palavras);
		return lista;
	}

	
}
