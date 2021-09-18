package Utils;

import java.io.IOException;
import java.util.Scanner;

import socketThread.Cliente;

public class ClienteThreadEnvia extends Thread{
	
	private Scanner console = new Scanner(System.in);
	
	Cliente clienteThread;
	
	
	public ClienteThreadEnvia(Cliente cliente) {
		clienteThread = cliente;
	}
	
	public void run(){  
		while(true){
			try {
				//clienteThread.setMsgEnviada(console.nextLine());	
				if(!clienteThread.getMsgEnviada().equals(" ")) {
					Utils.enviaPacote(clienteThread.socket, clienteThread.pacotecliente());
					clienteThread.setMsgEnviada(" ");
				}
			} catch (IOException e) {
				System.out.println("\nErro de conexão com o servidor (try catch do cliente)");
				break;
			}
		}
	}
}