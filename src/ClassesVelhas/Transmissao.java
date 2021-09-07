package ClassesVelhas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Transmissao extends Thread {
	
	private DataOutputStream fluxoSaida = null;
	private DataInputStream fluxoEntrada  = null;
	public String MsgEnviada = "";
	public String MsgRecebida = "";
	public String nameCliente = "";	
	
	public Transmissao(Socket recebe,Socket envia) {
		try {
			fluxoEntrada = new DataInputStream(recebe.getInputStream());
			fluxoSaida = new DataOutputStream(envia.getOutputStream());
			
			setNameCliente(fluxoEntrada.readUTF());
			System.out.println("Conexão Estabelecida com cliente: " + nameCliente + "\n");

			this.start();
			
		} catch (IOException e) {
			System.out.println("Erro ao receber mensagem do " + nameCliente);
		}
	}

	public void run(){  
			try {
				while(true){
					MsgRecebida = nameCliente + ": " + fluxoEntrada.readUTF();
					System.out.println(MsgRecebida);
					fluxoSaida.writeUTF(MsgRecebida);
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
