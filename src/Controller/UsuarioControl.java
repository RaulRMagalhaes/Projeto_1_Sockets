package Controller;

import View.JanelaPrincipal;

import socketThread.Cliente;

public class UsuarioControl {
	
	Cliente usuario = null;
   
	public UsuarioControl(String nomeUsuario) {
		usuario = new Cliente(nomeUsuario);
	}

    public void setNomeUsuario(String nomeUsuario){
        usuario.setNomeCliente(nomeUsuario);
    }
    
    public String getNomeUsuario(){
        return usuario.getNomeCliente();
    }
    
    public void setMensagemEnviar(String mensagem){
        usuario.setMsgEnviada(mensagem);
    }
    
    public String getMensagemEnviada() {
        return usuario.getMsgEnviada();
    }
   
    public String getMensagemRecebida(){
        return usuario.getMsgRecebida();
    }

    public boolean getClienteConectado() {
        return usuario.isConectado();
    }
}
