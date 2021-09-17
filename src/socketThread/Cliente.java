package socketThread;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import Utils.Utils;

public class Cliente extends Thread {

	static String host = "";
	Socket socket = null;
	static DataOutputStream fluxoSaida = null;
	DataInputStream fluxoEntrada = null;
	static int port = 9090;
	private Scanner console;
        private String msgStatus = "";
        
	String nomeCliente = "";
	String MsgRecebida= "a";
	String MsgEnviada= "b";
	int pontos = 10;
	boolean meuTurno = false;
	boolean conectado = false;

	HashMap<String,Object> dadosPartida = new HashMap<String,Object>();
	
	public Cliente(String nomeUsuario){
		try {
	        socket = new Socket("localhost", port);
	
	        setNomeCliente(nomeUsuario);
	
	        setMsgStatus(getNomeCliente() + " Conectado....");
	        System.out.println(getMsgStatus());
	
	        fluxoSaida = new DataOutputStream(socket.getOutputStream());
	        fluxoEntrada = new DataInputStream(socket.getInputStream());
	        console = new Scanner(System.in);
	
	        inicializacao();
	
	        this.start();
	        
	        
	       while(true){
	                this.setMsgEnviada("oi");
	                String pacoteEnviar = Utils.hashmapToString(this.pacotecliente());
	                fluxoSaida.writeUTF(pacoteEnviar);
	                fluxoSaida.flush();
	        }
	        

        } catch(Exception e){
            setMsgStatus("\nErro de conexao com o servidor");
            System.out.println(getMsgStatus());
        }
	}


	public void run(){
		while (true) {
			try {        
				String pacoteRecebido = (fluxoEntrada.readUTF());
				dadosPartida = Utils.stringToHashmap(pacoteRecebido);
				System.out.println(dadosPartida.get(Utils.NOME_OPONENTE) + ": " + dadosPartida.get("msgOponente"));
			} catch(Exception e) {
				System.out.println("\nErro ao receber mensagem do Servidor");
			}
		}
	}
		
    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }

    public String getMsgStatus() {
        return msgStatus;
    }
	public void inicializacao() {
		try {
			String pacoteEnviar = Utils.hashmapToString(this.pacotecliente());
			fluxoSaida.writeUTF(pacoteEnviar);
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
	
	public boolean isMeuTurno() {
		return meuTurno;
	}

	public void setMeuTurno(boolean meuTurno) {
		this.meuTurno = meuTurno;
	}

	
	public boolean isConectado() {
		return conectado;
	}

	public void setConectado(boolean conectado) {
		this.conectado = conectado;
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
	
	/*
	public static void main(String args[]){
		new Cliente("Cliente-" + new Random().nextInt(1000)); 
	}
    */
}