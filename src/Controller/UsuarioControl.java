package Controller;

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
    
    public void setMsgEnviada(String mensagem){
        usuario.setMsgEnviada(mensagem);
    }
    
    public String getMsgEnviada() {
        return usuario.getMsgEnviada();
    }
   
    public String getMsgmRecebida(){
        return usuario.getMsgRecebida();
    }

    public boolean isConectado() {
        return usuario.isConectado();
    }
}
