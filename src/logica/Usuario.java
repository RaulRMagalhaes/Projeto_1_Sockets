package logica;

import interfaceGrafica.JanelaUsuario;

public class Usuario {
	
	String nomeUsuario = "";
	int pontos = 0;	
	
	public Usuario(String nome) {
		nomeUsuario = nome;
		JanelaUsuario janela = new JanelaUsuario(nomeUsuario); 
	}
	
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

}
