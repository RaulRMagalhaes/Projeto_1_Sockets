package socketThread;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import org.json.simple.*;

import Utils.Utils;

public class Cliente extends Thread {

	static String host = "";
	Socket socket = null;
	ObjectOutputStream fluxoSaida = null;
	ObjectInputStream fluxoEntrada = null;
	static int port = 9090;
	private Scanner console;
	
	String nomeCliente = "";
	String MsgRecebida= "";
	String MsgEnviada= "";
	int pontos = 10;
	boolean clienteConectado = false;
	boolean minhaVez = false;
	
	public Cliente(String nomeCliente){
		try {
				socket = new Socket("localhost", port);
				
				setNomeCliente(nomeCliente);
	
				System.out.println(getNomeCliente() + " Conectado....");
				
				this.fluxoSaida = new ObjectOutputStream(socket.getOutputStream());
				this.fluxoEntrada = new ObjectInputStream(socket.getInputStream());
				console = new Scanner(System.in);
				
				System.out.println("teste printando hashmap");
				System.out.println("inicialização do cliente c/ Texto: " + this.pacoteSaida().toString());
				System.out.println("inicialização do cliente c/ JSON: " + this.pacoteSaida() + "\n\n");
				
				inicializaClienteNoServidor();
				
				//this.start();
	 
				while(true){
					this.setMsgEnviada(console.nextLine());
					fluxoSaida.writeObject(this.pacoteSaida()); 
					//String MsgEnviada = console.nextLine();
					//fluxoSaida.writeUTF(MsgEnviada);
					fluxoSaida.flush();
				}
			
			} catch(IOException e){
				System.out.println("\nErro de conexão com o servidor ou Servidor fora do ar");
			}
	}

	public void run(){
		while (true) {
			/*
			try {        
				HashMap<String, Object> pacoteRecebido = (HashMap<String, Object>) fluxoEntrada.readObject();
				this.atualizaCliente(pacoteRecebido);
				
				System.out.println(getMsgRecebida()); //APAGAR
				System.out.println("Dados atualizados: " + this.pacoteSaida().toString()); //APAGAR
			} catch(IOException | ClassNotFoundException e) {
				System.out.println("\nErro ao receber mensagem do Servidor");
				e.printStackTrace();
			}
			*/
			
			
			//HashMap<String, Object> pacoteRecebido = Utils.recebePacote(socket, "Erro ao receber mensagem do servidor");
			//this.atualizaCliente(pacoteRecebido);
		}
	}
		
	public void inicializaClienteNoServidor() {
		/*
		try {
			fluxoSaida.writeObject(this.pacoteSaida()); 
			fluxoSaida.flush();
		} catch (IOException e) {
			System.out.println("Erro ao inicializar dados do cliente no servidor");
		} 
		*/
		
		String pacoteEnciado = "Raul:23";
		Utils.enviaPacote(socket, pacoteEnciado, "Erro ao inicializar dados do cliente no servidor");
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
	
	public HashMap<String, Object> pacoteSaida() {
		HashMap<String,Object> info = new HashMap<String,Object>();

		info.put("nome", getNomeCliente());
		info.put("msgRecebida", getMsgRecebida());
		info.put("msgEnviada", getMsgEnviada());
		info.put("pontos", getPontos());
		
		//JSONObject clienteJson = new JSONObject(info);
		
		return info;
	}
	
	private void atualizaCliente(HashMap<String, Object> pacoteEntrada) {
		this.setNomeCliente(pacoteEntrada.get("name").toString());
		this.setMsgRecebida(pacoteEntrada.get("msgRecebida").toString());
		this.setMsgEnviada(pacoteEntrada.get("msgEnviada").toString());
		this.setPontos(Integer.parseInt(pacoteEntrada.get("pontos").toString()));
	}
	
	public static void main(String args[]){
		new Cliente("Cliente-" + new Random().nextInt(1000)); 
		
		/*
		String texto = "{\"nome\":\"Raul\",\"idade\":\"23\"}";
		System.out.println("String " + texto +  "\n");
		
		JSONObject json = new JSONObject();
		System.out.println("Json " + json +  "\n");
		*/
	}
}

