package socketThread;

import java.net.*;

public class Servidor extends Thread {
	
	ServerSocket servidor = null;
	static int port = 9090;
        String msgStatus = "";

	public Servidor(){
		try {
			servidor = new ServerSocket(port);
                        msgStatus = "Servidor iniciado. Aguardando conexão...";
			System.out.println(msgStatus);
			
			while (true) {
				new CanalClienteServidorCliente(servidor);
			}
			
		} catch(Exception e){
                        msgStatus = "Erro ao iniciar o servidor";
			System.out.println("\n" + msgStatus);
		}
		
	}
	
        /*
	public static void main(String args[]){
		new Servidor();
	}
        */
	
}


