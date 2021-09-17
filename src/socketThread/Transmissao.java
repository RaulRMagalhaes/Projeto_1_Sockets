package socketThread;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

import Utils.*;

public class Transmissao extends Thread {
	
	Socket recebe;
	Socket envia;
	
	public String MsgEnviada = "";
	public String MsgRecebida = "";
	public String nameCliente = "";	
	
	String pacoteRecebido = "";
	String pacoteEnviar = "";

	HashMap<String,Object> dadosPartida = new HashMap<String,Object>();
	
	public Transmissao(Socket recebe,Socket envia) {
		this.recebe = recebe;
		this.envia = envia;
		 
		this.start();
	}

	public void run(){  
		while(true){		
			try {
				dadosPartida = Utils.recebePacote(recebe);
				
				MsgRecebida = dadosPartida.get(Utils.NOME_CLIENTE) + ": " + dadosPartida.get(Utils.MSG_CLIENTE); // printa no servidor apenas para saber de quem é a mensagem recebida
				System.out.println(MsgRecebida); //visualizar a mensagem chegando no servidor
				
				dadosPartida = converteEntradaParaSaida(dadosPartida); //Converte os dadosCliente de A para dadosOponente de B
				
			} catch (IOException e) {
				
				System.out.println("Alguem teve problemas de conexao ou abandonou a partida" );				
				dadosPartida = msgErro("Seu oponende teve problemas de conexao ou abandonou a partida");
				
				try { 
					Utils.enviaPacote(envia, dadosPartida);
					recebe.close();
				} catch (Exception e1) { }
				
				break;
			}


				
			try { 
				Utils.enviaPacote(envia, dadosPartida);
			} catch (IOException e) { 
				System.out.println("Erro ao enviar pacotes");
				break;
			}

		}
		
	}
	
	public void setNameCliente(String nameCliente) {
		this.nameCliente = nameCliente;
	}
	
	public String getNameCliente() {
		return this.nameCliente;
	}
	
	public String getMsgRecebida() {
		return MsgRecebida;
	}

	public void setMsgRecebida(String msgRecebida) {
		MsgRecebida = msgRecebida;
	}

	public String getMsgEnviada() {
		return MsgEnviada;
	}

	public void setMsgEnviada(String msgEnviada) {
		MsgEnviada = msgEnviada;
	}
	
	private HashMap<String,Object> converteEntradaParaSaida(HashMap<String,Object> pacote) {
		//Converte os dadosCliente de A para dadosOponente de B
		pacote.replace(Utils.NOME_OPONENTE, pacote.get(Utils.NOME_CLIENTE));
		pacote.replace(Utils.MSG_OPONENTE, pacote.get(Utils.MSG_CLIENTE));
		pacote.replace(Utils.PONTOS_OPONENTE, pacote.get(Utils.PONTOS_CLIENTE));
		
		pacote.replace(Utils.NOME_CLIENTE, " ");
		pacote.replace(Utils.MSG_CLIENTE, " ");
		pacote.replace(Utils.PONTOS_CLIENTE, " ");
		
		return pacote;
	}
	
	private HashMap<String,Object> msgErro(String mensagem) {
		HashMap<String,Object> Partida = new HashMap<String,Object>();

		Partida.put(Utils.NOME_CLIENTE, " ");
		Partida.put(Utils.MSG_CLIENTE, " ");
		Partida.put(Utils.PONTOS_CLIENTE, 100);
		
		Partida.put(Utils.NOME_OPONENTE, " ");
		Partida.put(Utils.MSG_OPONENTE, mensagem);
		Partida.put(Utils.PONTOS_OPONENTE, " ");
				
		return Partida;
	}
}