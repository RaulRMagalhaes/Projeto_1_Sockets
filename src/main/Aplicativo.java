package main;
import interfaceGrafica.JanelaUsuario;
import logica.Usuario;
import socketThread.Cliente;
import socketThread.Servidor;


/**
 * @author raulmagalhaes
 */
public class Aplicativo {
			
	public static void main(String[] args) throws InterruptedException {
		new Servidor();
		Thread.sleep(1000);
		new Cliente("Joao"); 
		new Cliente("Paulo"); 
		new Cliente("Maria"); 
	}

}
