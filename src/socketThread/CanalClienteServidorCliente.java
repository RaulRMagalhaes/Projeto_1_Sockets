package socketThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CanalClienteServidorCliente {
	private Socket canal1 = null;
	private Socket canal2 = null;
	Transmissao Transmissao1;
	Transmissao Transmissao2;

	public CanalClienteServidorCliente(ServerSocket servidor) {
		try {
			canal1 = servidor.accept();
			canal2 = servidor.accept();
			
			new Transmissao(canal1, canal2);
			new Transmissao(canal2, canal1);
		
		} catch (IOException e) {
			System.out.println("Erro ao conectar canal de comunicacao com cliente no (CanalClienteServidorCliente)");
		}
	
	}

}