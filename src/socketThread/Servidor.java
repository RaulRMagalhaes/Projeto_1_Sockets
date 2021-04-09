package socketThread;

import java.net.*;

public class Servidor extends Thread {
	
	ServerSocket servidor = null;
	static int port = 9090;

	public Servidor(){
		try {
			servidor = new ServerSocket(port);
			System.out.println("Servidor iniciado. Aguardando conexão...");
			
			while (true) {
				new CanalClienteServidorCliente(servidor);
			}
			
		} catch(Exception e){
			System.out.println("\nErro ao iniciar o servidor");
		}
		
	}
	
	public static void main(String args[]){
		new Servidor();
	}
	
}


