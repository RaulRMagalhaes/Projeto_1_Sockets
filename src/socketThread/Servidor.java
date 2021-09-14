package socketThread;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Thread {
	
	ServerSocket servidor = null;
	public static int port = 9090;
        public static String msgStatus = "";
        boolean conectado = false;

	public Servidor(){
		try {
			servidor = new ServerSocket(port);
            setConectado(true);
            setMsgStatus("Servidor iniciado na porta [" + port + "]. Aguardando solicitação de conexão...");
			System.out.println(getMsgStatus());
			
			this.start();
			
		} catch(Exception e){
                        setMsgStatus("Erro ao iniciar o servidor");
			System.out.println("\n" + getMsgStatus());
		}
		
	}
	
	public void run(){
		while (true) {
			new CanalClienteServidorCliente(servidor);
		}
	}

	
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public boolean isConectado() {
        return conectado;
    }
    
    public static String getMsgStatus() {
        return msgStatus;
        
    }
    
    public static void setMsgStatus(String msgStatus) {
        Servidor.msgStatus = msgStatus;
    }
    
    public void fechar(){
            try {
                servidor.close();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        /*
	public static void main(String args[]){
		new Servidor();
	}
        */
	
}


