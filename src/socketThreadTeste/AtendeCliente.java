package socketThreadTeste;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class AtendeCliente extends Thread {
	
	Socket socketCliente;
	static DataOutputStream fluxoSaida = null;
	DataInputStream fluxoEntrada  = null;
	static String MsgEnviada= "";
	String MsgRecebida= "";
	String nameCliente = "";
	private Scanner console = new Scanner(System.in);;
	
	public AtendeCliente(Socket canalCliente) {
		socketCliente = canalCliente;
		try {			
			fluxoEntrada = new DataInputStream(socketCliente.getInputStream());
			fluxoSaida = new DataOutputStream(socketCliente.getOutputStream());
			console = new Scanner(System.in);
      
			setNameCliente(fluxoEntrada.readUTF());
			
			System.out.println("Conexão Estabelecida com cliente: " + nameCliente + "\n");

			
			this.start();
      
			while(true){
				//System.out.println("Servidor: ");
				String MsgEnviada = console.nextLine(); 
				fluxoSaida.writeUTF(MsgEnviada);
				fluxoSaida.flush();
			}
      
		} catch(Exception e){
			System.out.println("\nErro na conexão com o " + nameCliente);
		}
	}

	public void run(){
		try {
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
