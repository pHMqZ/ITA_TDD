package com.pms.tdd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Armazenamento {
	
	private UsuariosComPontos usersPontuacao;
	private String nomeArquivo;
	
	public Armazenamento(String nomeArquivo) {
		super();
		this.nomeArquivo = nomeArquivo;
		try {
			lerArquivo();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao ler o arquivo");
		}
		
	}
	
	
	public String registraPontos(String nomeUsuario, String tipoPonto, int pontos) {
		UsuarioComPontuacao user = new UsuarioComPontuacao(nomeUsuario, tipoPonto, pontos);
		
		try {
			escreverArquivo(user);
			usersPontuacao.adicionaUsuarioComPontuacao(user);
			return "O usuário " + nomeUsuario + " recebeu " + pontos + " pontos do tipo " + tipoPonto;
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro ao salvar no arquivo";
		}
 	}

	public int quantidadePontosPorTipos(String usuario, String tipoPonto) {
		return usersPontuacao.getPontuacaoPorNomeUsuarioETipoPontuacao(usuario, tipoPonto);
	}
	
	public UsuariosComPontos getUsuariosComPontos() {
		return usersPontuacao;
	}
	
	public List<String> getTiposDePontosPorUsuario(String nomeUsuario) {
		List<String> tiposPontos = new ArrayList<>();
		
		for (UsuarioComPontuacao usuario : usersPontuacao.getUsuariosComPontuacao()) {
			if(nomeUsuario.equals(usuario.getNomeUsuario()))
				tiposPontos.add(usuario.getTipoPonto());
		}
		
		return tiposPontos;
	}
	
	protected void escreverArquivo(UsuarioComPontuacao usuario) throws IOException {
		File arquivo = new File("./" + nomeArquivo);
		FileWriter writer = new FileWriter(arquivo, true);
		PrintWriter printWriter = new PrintWriter(writer);
		
		printWriter.println(usuario.toString());
		printWriter.flush();
		printWriter.close();
	}
	
	protected void lerArquivo() throws IOException {
		File arquivo = new File("./" + nomeArquivo);
		usersPontuacao = new UsuariosComPontos();
		
		if (arquivo.exists()) {
			String aux;
			BufferedReader reader = new BufferedReader(new FileReader("./" + nomeArquivo));
			
			while ((aux = reader.readLine()) != null) {
				String[] string = aux.split(";");
				String nome = string[0];
				String tipoPontuacao = string[1];
				String pontuacao = string[2];
				
				usersPontuacao.adicionaUsuarioComPontuacao(new UsuarioComPontuacao(nome, tipoPontuacao, Integer.parseInt(pontuacao)));
			}
			reader.close();
		} else {
			arquivo.createNewFile();
		}
	}
}
