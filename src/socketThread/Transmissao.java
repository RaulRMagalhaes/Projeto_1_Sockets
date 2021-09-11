package socketThread;

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
		
		//dadosPartida = Utils.recebePacote(recebe, "Erro ao receber dados de inicialização do cliente");
		//setNameCliente(dadosPartida.get("nomeCliente").toString());  //AQUI EU RECEBO OS DADO DE UM CLIENTE PELA PRIMEIRA VEZ - DEVO SALVAR OS DADOS DE UM CLIENTE NO SERVIDOR...
		//System.out.println("Conexão Estabelecida com cliente: " + getNameCliente() + "\n");
		 
		this.start();
	}

	public void run(){  
		while(true){		
			dadosPartida = Utils.recebePacote(recebe, "Erro ao receber mensagem do cliente");

			MsgRecebida = dadosPartida.get(Utils.NOME_CLIENTE) + ": " + dadosPartida.get(Utils.MSG_CLIENTE); // printa no servidor apenas para saber de quem é a mensagem recebida
			System.out.println(MsgRecebida); //visualizar a mensagem chegando no servidor
			
			//Converte os dadosCliente de A para dadosOponente de B
			dadosPartida.replace(Utils.NOME_OPONENTE, dadosPartida.get(Utils.NOME_CLIENTE));
			dadosPartida.replace(Utils.MSG_OPONENTE, dadosPartida.get(Utils.MSG_CLIENTE));
			dadosPartida.replace(Utils.PONTOS_OPONENTE, dadosPartida.get(Utils.PONTOS_CLIENTE));
			
			dadosPartida.replace(Utils.NOME_CLIENTE, " ");
			dadosPartida.replace(Utils.MSG_CLIENTE, " ");
			dadosPartida.replace(Utils.MSG_CLIENTE, " ");
			
			Utils.enviaPacote(envia, dadosPartida, "Erro ao enviar mensagem para o cliente");
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
}