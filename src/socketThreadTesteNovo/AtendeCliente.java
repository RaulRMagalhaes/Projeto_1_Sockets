package socketThreadTesteNovo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class AtendeCliente extends Thread {
	
	Socket socketCliente;
	DataInputStream fluxoEntrada  = null;
	String MsgRecebida= "";
	String nameCliente = "";
	
	public AtendeCliente(Socket canalCliente) {
		socketCliente = canalCliente;
		this.start();
	}

	public void run(){
		try {
			fluxoEntrada = new DataInputStream(socketCliente.getInputStream());
			setNameCliente(fluxoEntrada.readUTF());
			System.out.println("Conexão Estabelecida com cliente: " + nameCliente + "\n");
			
			while(true){
				MsgRecebida = fluxoEntrada.readUTF();
				System.out.println(nameCliente + ": " + MsgRecebida);
			}
		} catch(Exception e) {
			System.out.println("\nErro ao receber mensagem do " + nameCliente);
		}
	}
	
	public void setNameCliente(String nameCliente) {
		this.nameCliente = nameCliente;
	}

}
