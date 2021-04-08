package socketThread;

import java.net.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

class ServidorThread extends Thread {
	ServerSocket servidor = null;
	Socket socket = null;
	static DataOutputStream fluxoSaida = null;
	DataInputStream fluxoEntrada  = null;
	String MsgRecebida= "";
	static String MsgEnviada= "";
	static int port = 9090;
	private Scanner console;

	ServidorThread(){
		try {
			servidor = new ServerSocket(port);
			System.out.println("Servidor iniciado. Aguardando conexão...");
      
			socket = servidor.accept();
			System.out.println("Conexão Estabelecida com cliente: " );
      
			fluxoSaida = new DataOutputStream(socket.getOutputStream());
			fluxoEntrada = new DataInputStream(socket.getInputStream());
			console = new Scanner(System.in);
      
			this.start();
      
			while(true){
				System.out.println("Servidor: ");
				String MsgEnviada = console.nextLine(); 
				fluxoSaida.writeUTF(MsgEnviada);
				fluxoSaida.flush();
			}
      
		} catch(Exception e){
			System.out.println("Erro na conexão com o cliente");
		}
	}

	public void run(){
		try {
			while(true){
				MsgRecebida = fluxoEntrada.readUTF();
				System.out.println("Cliente: " + MsgRecebida);
			}
		} catch(Exception e) {
			System.out.println("Erro ao receber mensagem do cliente");
		}
	}

	public static void main(String args[]){
		new ServidorThread();
	}
}
