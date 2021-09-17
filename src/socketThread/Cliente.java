package socketThread;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import Utils.ClienteThreadEnvia;
import Utils.Utils;

public class Cliente extends Thread {

	static String host = "";
	public Socket socket = null;
	//static DataOutputStream fluxoSaida = null;
	//DataInputStream fluxoEntrada = null;
	static int port = 9090;
	//private Scanner console;
	
	ClienteThreadEnvia threadEnvia = null;
	
	String nomeCliente = "";
	String MsgRecebida= "a";
	String MsgEnviada= "b";
	int pontos = 10;
	
	HashMap<String,Object> dadosPartida = new HashMap<String,Object>();
	
	public Cliente(){
		try {
			socket = new Socket("localhost", port);
			
			setNomeCliente("Cliente-" + new Random().nextInt(1000));
			System.out.println(getNomeCliente() + " Conectado....");

			//console = new Scanner(System.in);

			inicializacao();
			
			this.start();
 
			/*
			while(true){
				this.setMsgEnviada(console.nextLine());	
				Utils.enviaPacote(socket, this.pacotecliente());
			}
			*/
			threadEnvia =  new ClienteThreadEnvia(this);
			threadEnvia.start();
			
		} catch(Exception e){
			System.out.println("\nErro de conexão com o servidor (try catch do cliente)");
		}
	}

	public void run(){
		while (true) {
			try {        
				dadosPartida = Utils.recebePacote(socket);
				System.out.println(dadosPartida.get(Utils.NOME_OPONENTE) + ": " + dadosPartida.get("msgOponente"));
			} catch(Exception e) {
				System.out.println("\nErro ao receber mensagem do Servidor (try catch do cliente)");
				break;
			}
		}
	}
		
	public void inicializacao() {
		try {
			Utils.enviaPacote(socket, this.pacotecliente());
			
		} catch (Exception e) {
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
		return this.pacotecliente().get("msgOponente").toString();
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
	
	
	public HashMap<String, Object> pacotecliente() {
		HashMap<String,Object> dadosPartida = new HashMap<String,Object>();

		dadosPartida.put("nomeCliente", getNomeCliente());
		dadosPartida.put("msgCliente", getMsgEnviada());
		dadosPartida.put("pontosCliente", getPontos());
		
		dadosPartida.put("nomeOponente", " ");
		dadosPartida.put("msgOponente", " ");
		dadosPartida.put("pontosOponente", " ");
				
		return dadosPartida;
	}	
	
	
	public static void main(String args[]){
		new Cliente(); 
	}
}