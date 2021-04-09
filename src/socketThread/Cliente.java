package socketThread;

import java.net.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Cliente extends Thread {

	static String host = "";
	Socket socket = null;
	static DataOutputStream fluxoSaida = null;
	DataInputStream fluxoEntrada = null;
	String MsgRecebida= "";
	static String MsgEnviada= "";
	static int port = 9090;
	private Scanner console;
	String nomeCliente = "Cliente-" + new Random().nextInt(1000);

	public Cliente(){
		try {
			socket = new Socket("localhost", port);
			System.out.println(nomeCliente + " Conectado....");
			
			fluxoSaida = new DataOutputStream(socket.getOutputStream());
			fluxoEntrada = new DataInputStream(socket.getInputStream());
			console = new Scanner(System.in);
			
			getNomeCliente();
			
			this.start();
 
			while(true){
					//System.out.println(nomeCliente + ": ");
					String MsgEnviada = console.nextLine();
					fluxoSaida.writeUTF(MsgEnviada);
					fluxoSaida.flush();
			}
			
			} catch(Exception e){
				System.out.println("\nErro de conexão com o servidor");
			}
	}

	public void run(){
		while (true) {
			try {        
				MsgRecebida = fluxoEntrada.readUTF();
				System.out.println("Msg Servidor: " + MsgRecebida);
			} catch(Exception e) {
				System.out.println("\nErro ao receber mensagem do Servidor");
			}
		}
	}
	
	public void getNomeCliente() {
		try {
			fluxoSaida.writeUTF(nomeCliente);
			fluxoSaida.flush();
		} catch (IOException e) {
			System.out.println("Erro ao retornar nome do cliente");
		}
	}
	
	public static void main(String args[]){
		//host = args.length == 0 ? "localhost" : args[0];
		new Cliente(); 
	}
}

