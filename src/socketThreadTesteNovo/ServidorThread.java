package socketThreadTesteNovo;

import java.net.*;



class ServidorThread extends Thread {
	
	ServerSocket servidor = null;
	Socket socket = null;
	
	static int port = 9090;

	ServidorThread(){
		try {
			servidor = new ServerSocket(port);
			System.out.println("Servidor iniciado. Aguardando conexão...");
			
			while (true) {
				AtendeCliente cliente = new AtendeCliente(servidor.accept());

			}
			
		} catch(Exception e){
			System.out.println("\nErro ao iniciar o servidor");
		}
	}

	/*
	public void run(){
		try { AtendeCliente cliente1 = new AtendeCliente(servidor.accept());
		} catch(Exception e) {
			System.out.println("Erro ao receber mensagem do cliente 1");
		}
	}
	*/
	
	public static void main(String args[]){
		new ServidorThread();
	}
}


