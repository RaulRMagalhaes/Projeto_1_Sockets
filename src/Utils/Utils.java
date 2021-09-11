package Utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;
import java.util.HashMap;

public class Utils {
	
	private static DataOutputStream fluxoSaida = null;
	private static DataInputStream fluxoEntrada  = null;
	
	static String pacoteRecebido = "";
	static String pacoteEnviar = "";
	static HashMap<String,Object> dadosPartida = new HashMap<String,Object>();

	public static String NOME_CLIENTE = "nomeCliente";
	public static String MSG_CLIENTE = "msgCliente";
	public static String PONTOS_CLIENTE = "pontosCliente";
	
	public static String NOME_OPONENTE = "nomeOponente";
	public static String MSG_OPONENTE = "msgOponente";
	public static String PONTOS_OPONENTE = "pontosOponente";
	
	
	public static void enviaPacote(Socket envia, HashMap<String,Object> dadosPartida, String mensagemErro) {
		try {
			pacoteEnviar = hashmapToString(dadosPartida);
			
			fluxoSaida = new DataOutputStream(envia.getOutputStream());
			fluxoSaida.writeUTF(pacoteEnviar);
			fluxoSaida.flush();
		} catch (IOException e) {
			System.out.println(mensagemErro);
			e.printStackTrace();
		}
	}
	
	public static HashMap<String,Object> recebePacote(Socket recebe, String mensagemErro) {
		try {
			fluxoEntrada = new DataInputStream(recebe.getInputStream());
			pacoteRecebido = fluxoEntrada.readUTF();
			
			dadosPartida = Utils.stringToHashmap(pacoteRecebido);
		} catch (IOException e) {
			System.out.println(mensagemErro);
			e.printStackTrace();
		}
		return dadosPartida;
	}
	
	public static HashMap<String, Object> stringToHashmap(String pacoteRecebido) {
		// nomeCliente : msgCliente : pontosCliente : nomeOponente : msgOponente : pontosOponente  
		String[] splited = pacoteRecebido.split(":"); 
		
		HashMap<String,Object> dadosPartida = new HashMap<String,Object>();
		
		dadosPartida.put(NOME_CLIENTE, splited[0]);
		dadosPartida.put(MSG_CLIENTE, splited[1]);
		dadosPartida.put(PONTOS_CLIENTE, splited[2]);
		
		dadosPartida.put(NOME_OPONENTE, splited[3]);
		dadosPartida.put(MSG_OPONENTE, splited[4]);
		dadosPartida.put(PONTOS_OPONENTE, splited[5]);
						
		return dadosPartida;
	}	
	
	public static String hashmapToString(HashMap<String, Object> pacoteEnviar) {
		String dadosPartida = "";
		
		dadosPartida = pacoteEnviar.get(NOME_CLIENTE) + ":" +
						pacoteEnviar.get(MSG_CLIENTE) + ":" +
						pacoteEnviar.get(PONTOS_CLIENTE) + ":" +
						
						pacoteEnviar.get(NOME_OPONENTE) + ":" +
						pacoteEnviar.get(MSG_OPONENTE) + ":" +
						pacoteEnviar.get(PONTOS_OPONENTE);
		
		return dadosPartida;
	
	}
}
