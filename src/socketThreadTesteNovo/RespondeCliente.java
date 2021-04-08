package socketThreadTesteNovo;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class RespondeCliente extends Thread {
	
	Socket socketCliente;
	static DataOutputStream fluxoSaida = null;
	static String MsgEnviada= "";
	String nameCliente = "";
	private Scanner console = new Scanner(System.in);
	
	public RespondeCliente(Socket canalCliente) {
		socketCliente = canalCliente;
		this.start();
	}

	public void run(){
		try {
			fluxoSaida = new DataOutputStream(socketCliente.getOutputStream());
			while(true){
				String MsgEnviada = console.nextLine(); 
				fluxoSaida.writeUTF(MsgEnviada);
				fluxoSaida.flush();
			}
		} catch(Exception e) {
			System.out.println("\nErro ao enviar mensagem para o Cliente");
		}
	}

}
