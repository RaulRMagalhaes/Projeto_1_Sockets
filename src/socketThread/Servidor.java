package socketThread;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

import Utils.Utils;

import org.json.simple.*;

public class Servidor extends Thread {
	
	ServerSocket servidor = null;
	static int port = 9090;
	public ArrayList<HashMap<String, Object>> listaDeClientes = new ArrayList<HashMap<String, Object>>();

	public Servidor(){
		try {
			servidor = new ServerSocket(port);
			System.out.println("Servidor iniciado. Aguardando conexão...");
			
			while (true) {
				conectaClientes(servidor);
				//new CanalClienteServidorCliente(servidor);
			}
			
		} catch(Exception e){
			System.out.println("\nErro ao iniciar o servidor");
		}
		
	}
	
	private void conectaClientes(ServerSocket servidor) {		
		try {
			Socket conexao = servidor.accept();
			System.out.println("   Cliente conectado");
			
			//HashMap<String, Object> dadosCliente = 
			Utils.recebePacote(conexao, "Erro ao receber mensagem do cliente");
			
			System.out.println("   Dados enviados para o servidor");
			
			//listaDeClientes.add(dadosCliente);
			
			System.out.println("\n" + listaDeClientes + "\n"); // APAGAR
			
		} catch (IOException e) {
			System.out.println("Erro ao conectar um cliente com o servidor");
		}
	}
	
	public static void main(String args[]){
		new Servidor();
	}
	
}


