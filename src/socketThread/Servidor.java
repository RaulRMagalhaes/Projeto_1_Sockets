package socketThread;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Thread {
	
	ServerSocket servidor = null;
	public int port = 9090;
    public String msgStatus = "";
    public boolean conectado = false;

	public Servidor(){
		try {
			servidor = new ServerSocket(port);
            setConectado(true);
            setMsgStatus("Servidor iniciado na porta [" + port + "]. Aguardando solicitacao de conexao...");
			System.out.println(getMsgStatus());
			
			this.start();
			
		} catch(Exception e){
            setMsgStatus("Erro ao iniciar o servidor");
			System.out.println("\n" + getMsgStatus());
		}
		
	}
	
	public void run(){
		while (true) {
			new Partida(servidor);
		}
	}

	
    public void setConectado(boolean isConectado) {
    	this.conectado = isConectado;
    }

    public boolean isConectado() {
        return conectado;
    }
    
    public String getMsgStatus() {
        return msgStatus;   
    }
    
    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }
    
    public void fechar(){
            try {
                servidor.close();
            } catch (IOException ex) {
                setMsgStatus("Erro ao tentar fechar o servidor");
    			System.out.println("\n" + getMsgStatus());
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
    /*
	public static void main(String args[]){
		new Servidor();
	}
	*/
       
}


