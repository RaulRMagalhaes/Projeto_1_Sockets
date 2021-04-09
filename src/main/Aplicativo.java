package main;
import interfaceGrafica.JanelaUsuario;
import logica.Usuario;
import socketThreadTesteNovo.ClienteThread;
import socketThreadTesteNovo.ServidorThread;

/**
 * @author raulmagalhaes
 */
public class Aplicativo {
			
	public static void main(String[] args) throws InterruptedException {
		new Servidor();
		Thread.sleep(1000);
		new Cliente(); 
		new Cliente(); 
		new Cliente(); 
	}

}
