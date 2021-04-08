package socketThread;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteThread extends Thread {

	static String host = "";
	Socket socket = null;
	static DataOutputStream fluxoSaida = null;
	DataInputStream fluxoEntrada = null;
	String MsgRecebida= "";
	static String MsgEnviada= "";
	static int port = 9090;
	private Scanner console;

	ClienteThread(){
		try {
			socket = new Socket("localhost", port);
			System.out.println("Conectado....");
			
			fluxoSaida = new DataOutputStream(socket.getOutputStream());
			fluxoEntrada = new DataInputStream(socket.getInputStream());
			console = new Scanner(System.in);
			
			this.start();
 
			while(true){
					System.out.println("Eu Cliente: ");
					String MsgEnviada = console.nextLine();
					fluxoSaida.writeUTF(MsgEnviada);
					fluxoSaida.flush();
			}
			
			} catch(Exception e){
				System.out.println("Erro de conex�o com o servidor");
			}
	}

	public void run(){
		while (true) {
			try {        
				MsgRecebida = fluxoEntrada.readUTF();
				System.out.println("Msg Servidor: " + MsgRecebida);
			} catch(Exception e) {
				System.out.println("Erro ao receber mensagem do Servidor");
			}
		}
	}

 
	public static void main(String args[]){
		//host = args.length == 0 ? "localhost" : args[0];
		new ClienteThread(); 
	}
}

