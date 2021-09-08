package socketThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

import Utils.*;

public class Transmissao extends Thread {
	
	private DataOutputStream fluxoSaida = null;
	private DataInputStream fluxoEntrada  = null;
	public String MsgEnviada = "";
	public String MsgRecebida = "";
	public String nameCliente = "";	
	
	String pacoteRecebido = "";
	String pacoteEnviar = "";

	HashMap<String,Object> dadosPartida = new HashMap<String,Object>();
	
	public Transmissao(Socket recebe,Socket envia) {
		try {
			fluxoEntrada = new DataInputStream(recebe.getInputStream());
			fluxoSaida = new DataOutputStream(envia.getOutputStream());
			
			pacoteRecebido = fluxoEntrada.readUTF();
			dadosPartida = Utils.stringToHashmap(pacoteRecebido);
			setNameCliente(dadosPartida.get("nomeCliente").toString());  //AQUI EU DEVO SALVAR OS DADOS DE UM CLIENTE NO SERVIDOR...
			
			System.out.println("Conexão Estabelecida com cliente: " + getNameCliente() + "\n");
			 
			this.start();
			
		} catch (IOException e) {
			System.out.println("Erro ao receber mensagem do " + getNameCliente());
		}
	}

	public void run(){  
			try {
				while(true){
					pacoteRecebido = fluxoEntrada.readUTF();
					dadosPartida = Utils.stringToHashmap(pacoteRecebido);
					
					MsgRecebida = dadosPartida.get(Utils.NOME_CLIENTE) + ": " + dadosPartida.get(Utils.MSG_CLIENTE); // printa no servidor apenas para saber de quem é a mensagem recebida
					System.out.println(MsgRecebida); //visualizar a mensagem chegando no servidor
					
					//Converte os dadosCliente de A para dadosOponente de B
					dadosPartida.replace(Utils.NOME_OPONENTE, dadosPartida.get(Utils.NOME_CLIENTE));
					dadosPartida.replace(Utils.MSG_OPONENTE, dadosPartida.get(Utils.MSG_CLIENTE));
					dadosPartida.replace(Utils.PONTOS_OPONENTE, dadosPartida.get(Utils.PONTOS_CLIENTE));
					
					dadosPartida.replace(Utils.NOME_CLIENTE, " ");
					dadosPartida.replace(Utils.MSG_CLIENTE, " ");
					dadosPartida.replace(Utils.MSG_CLIENTE, " ");
					
					pacoteEnviar = Utils.hashmapToString(dadosPartida);
					fluxoSaida.writeUTF(pacoteEnviar);
					fluxoSaida.flush();
				}
			} catch (IOException e) {
				System.out.println(nameCliente + "saiu ou Erro de comunicação");
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