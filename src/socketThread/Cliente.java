package socketThread;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import org.json.simple.*;

public class Cliente extends Thread {

	static String host = "";
	Socket socket = null;
	static DataOutputStream fluxoSaida = null;
	DataInputStream fluxoEntrada = null;
	static int port = 9090;
	private Scanner console;
	
	String nomeCliente = "";
	String MsgRecebida= "";
	String MsgEnviada= "";
	int pontos = 10;
	
	public Cliente(String nomeCliente){
		try {
				socket = new Socket("localhost", port);
				
				setNomeCliente(nomeCliente);
	
				System.out.println(getNomeCliente() + " Conectado....");
				
				fluxoSaida = new DataOutputStream(socket.getOutputStream());
				fluxoEntrada = new DataInputStream(socket.getInputStream());
				console = new Scanner(System.in);

				inicializacao();
				
				this.start();
	 
				while(true){
					this.setMsgEnviada(console.nextLine());
					fluxoSaida.writeUTF(this.pacoteJson()); ///procurar como enviar um OBJETO pelo socket
					//String MsgEnviada = console.nextLine();
					//fluxoSaida.writeUTF(MsgEnviada);
					fluxoSaida.flush();
				}
			
			} catch(Exception e){
				System.out.println("\nErro de conexão com o servidor");
			}
	}

	public void run(){
		while (true) {
			try {        
				this.setMsgRecebida(fluxoEntrada.readUTF());
				System.out.println(MsgRecebida);
			} catch(Exception e) {
				System.out.println("\nErro ao receber mensagem do Servidor");
			}
		}
	}
		
	public void inicializacao() {
		try {
			fluxoSaida.writeUTF(getNomeCliente());
			fluxoSaida.flush();
		} catch (IOException e) {
			System.out.println("Erro ao inicializar dados do cliente");
		} 
		
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getNomeCliente() {
		return this.nomeCliente;
	}
	
	public String getMsgRecebida() {
		return MsgRecebida;
	}

	public void setMsgRecebida(String msgRecebida) {
		MsgRecebida = msgRecebida;
	}

	public String getMsgEnviada() {
		return MsgEnviada;
	}

	public void setMsgEnviada(String msgEnviada) {
		MsgEnviada = msgEnviada;
	}
	
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public JSONObject pacoteJson() {
		HashMap<String,Object> info = new HashMap<String,Object>();

		info.put("nome", getNomeCliente());
		info.put("msgRecebida", getMsgRecebida());
		info.put("msgEnviada", getMsgEnviada());
		info.put("pontos", getPontos());
		
		JSONObject clienteJson = new JSONObject(info);
		
		return clienteJson;
	}
	
	public static void main(String args[]){
		//host = args.length == 0 ? "localhost" : args[0];
		new Cliente("Cliente-" + new Random().nextInt(1000)); 
		
		//System.out.println(a.pacoteJson().toString());
		//System.out.println("\n nome: " + a.pacoteJson().get("nome"));
		//System.out.println("\n pontos: " + a.pacoteJson().get("pontos"));

	}
}

