package Controller;

import View.JanelaPrincipal;

import socketThread.Cliente;

public class UsuarioControl {
    Cliente usuario = new Cliente();
        
    public void setNomeUsuario(String nomeUsuario){
        usuario.setNomeCliente(nomeUsuario);
    }
    
    public String getNomeUsuario(){
        return usuario.getNomeCliente();
    }
    
    public void setMsgEnviar(String mensagem){
        usuario.setMsgEnviada(mensagem);
    }
    
    public String getMsgEnviar() {
        return usuario.getMsgEnviada();
    }
   
    public String getMsgmRecebida(){
        return usuario.getMsgRecebida();
    }

    public boolean isConectado() {
        return usuario.isConectado();
    }
}
