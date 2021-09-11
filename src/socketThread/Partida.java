package socketThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import Utils.Utils;

public class Partida {
	
	private Socket canalCliente1 = null;
	private Socket canalCliente2 = null;
	
	Transmissao Transmissao1;
	Transmissao Transmissao2;
	
	HashMap<String,Object> dadosPartida = new HashMap<String,Object>();

	public Partida(ServerSocket servidor) {
		canalCliente1 = ConectaCliente(servidor);
		canalCliente2 = ConectaCliente(servidor);
		
		new Transmissao(canalCliente1, canalCliente2);
		new Transmissao(canalCliente2, canalCliente1);

	}
	
	public Socket ConectaCliente(ServerSocket servidor){
		Socket canalCliente = null;
		try {
			canalCliente = servidor.accept();
			
			dadosPartida = Utils.recebePacote(canalCliente, "Erro ao receber dados de inicialização do cliente");
			System.out.println("Conexão Estabelecida com cliente: " + dadosPartida.get("nomeCliente").toString() + "\n");
		} catch (IOException e) {
			System.out.println("Erro ao conectar canal de comunicação com cliente na Partida");
			e.printStackTrace();
		}
		return canalCliente;
	}

}