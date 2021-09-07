package Utils;

//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class Utils {
	
	public static void enviaPacote(Socket socket, String pacoteEnviado, String msgErro) {
		try {     
			ObjectOutputStream fluxoSaida = new ObjectOutputStream(socket.getOutputStream());
			fluxoSaida.writeObject(pacoteEnviado); 
			fluxoSaida.flush();
		} catch(IOException e) {
			System.out.println("\n" + msgErro);
			e.printStackTrace();
		}
	}
	
	public static void recebePacote(Socket socket, String msgErro) {
		//HashMap<String, Object> pacoteRecebido = null;
		try {     
			ObjectInputStream fluxoEntrada = new ObjectInputStream(socket.getInputStream());
			String pacoteRecebido = (String) fluxoEntrada.readObject();
			
			String pacoteTexto = fluxoEntrada.readObject().toString(); //APAGAR
			System.out.println("objeto JSON: " + pacoteRecebido.toString());      //APAGAR
			System.out.println("objeto TEXTO" + pacoteTexto);          //APAGAR
			
		} catch (IOException e) {
			System.out.println("\n" + msgErro);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//return pacoteRecebido;
	}
	
}
