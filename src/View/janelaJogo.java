/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UsuarioControl;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import socketThread.Servidor;

/**
 *
 * @author raulmagalhaes
 */
public class janelaJogo extends javax.swing.JFrame {
    
    Servidor servidor = null;
    UsuarioControl usuario = null;
    int num = 0;
    String chat = "";
    String msgLogServidor = "";

    public janelaJogo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelRaiz = new javax.swing.JPanel();
        painelLogin = new javax.swing.JPanel();
        painelFormularioLogin = new javax.swing.JPanel();
        labelNomeUsuarioLogin = new javax.swing.JLabel();
        campoNomeUsuario = new javax.swing.JTextField();
        botaoJogarLogin = new javax.swing.JButton();
        painelPrincipal = new javax.swing.JPanel();
        painelJogo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        painelChat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTextoChat = new javax.swing.JTextArea();
        campoTextoChat = new javax.swing.JTextField();
        botaoEnviar = new javax.swing.JButton();
        painelServidor = new javax.swing.JPanel();
        painelListaUsuarios = new javax.swing.JPanel();
        labelListaUsuarios = new javax.swing.JLabel();
        scrollLlistaUsuarios = new javax.swing.JScrollPane();
        listaUsuarios = new javax.swing.JList<>();
        painelLogServidor = new javax.swing.JPanel();
        painelScrollLogServidor = new javax.swing.JScrollPane();
        areaTextoLogServidor = new javax.swing.JTextArea();
        labelLogServidor = new javax.swing.JLabel();
        butaoStartServidor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - Jogo");
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        painelRaiz.setLayout(new java.awt.CardLayout());

        painelLogin.setPreferredSize(new java.awt.Dimension(800, 500));

        labelNomeUsuarioLogin.setText("Nome:");

        campoNomeUsuario.setToolTipText("Digite seu nome");
        campoNomeUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        campoNomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeUsuarioActionPerformed(evt);
            }
        });

        botaoJogarLogin.setText("Jogar");
        botaoJogarLogin.setToolTipText("Clique para definir o nome e entrar na sala de jogo");
        botaoJogarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoJogarLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelFormularioLoginLayout = new javax.swing.GroupLayout(painelFormularioLogin);
        painelFormularioLogin.setLayout(painelFormularioLoginLayout);
        painelFormularioLoginLayout.setHorizontalGroup(
            painelFormularioLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormularioLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNomeUsuarioLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(campoNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(painelFormularioLoginLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(botaoJogarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelFormularioLoginLayout.setVerticalGroup(
            painelFormularioLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormularioLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFormularioLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNomeUsuarioLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoJogarLogin)
                .addContainerGap())
        );

        campoNomeUsuario.getAccessibleContext().setAccessibleName("");
        botaoJogarLogin.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout painelLoginLayout = new javax.swing.GroupLayout(painelLogin);
        painelLogin.setLayout(painelLoginLayout);
        painelLoginLayout.setHorizontalGroup(
            painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLoginLayout.createSequentialGroup()
                .addContainerGap(283, Short.MAX_VALUE)
                .addComponent(painelFormularioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
        );
        painelLoginLayout.setVerticalGroup(
            painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(painelFormularioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        painelRaiz.add(painelLogin, "telaLogin");
        painelLogin.getAccessibleContext().setAccessibleName("");

        painelPrincipal.setRequestFocusEnabled(false);

        painelJogo.setPreferredSize(new java.awt.Dimension(478, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/SurakartaTabuleiro.png"))); // NOI18N

        javax.swing.GroupLayout painelJogoLayout = new javax.swing.GroupLayout(painelJogo);
        painelJogo.setLayout(painelJogoLayout);
        painelJogoLayout.setHorizontalGroup(
            painelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelJogoLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel2)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        painelJogoLayout.setVerticalGroup(
            painelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelJogoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        areaTextoChat.setColumns(20);
        areaTextoChat.setRows(5);
        jScrollPane1.setViewportView(areaTextoChat);

        campoTextoChat.setToolTipText("Digite para enviar uma mensagem ao seu oponente");

        botaoEnviar.setText("Enviar");
        botaoEnviar.setToolTipText("Clique para enviar ");
        botaoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelChatLayout = new javax.swing.GroupLayout(painelChat);
        painelChat.setLayout(painelChatLayout);
        painelChatLayout.setHorizontalGroup(
            painelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addGroup(painelChatLayout.createSequentialGroup()
                        .addComponent(campoTextoChat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoEnviar)))
                .addContainerGap())
        );
        painelChatLayout.setVerticalGroup(
            painelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelChatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEnviar)
                    .addComponent(campoTextoChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelJogo, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelJogo, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelRaiz.add(painelPrincipal, "telaPrincipal");

        painelServidor.setPreferredSize(new java.awt.Dimension(800, 500));

        labelListaUsuarios.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelListaUsuarios.setText("Lista de Usuários");

        listaUsuarios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scrollLlistaUsuarios.setViewportView(listaUsuarios);

        javax.swing.GroupLayout painelListaUsuariosLayout = new javax.swing.GroupLayout(painelListaUsuarios);
        painelListaUsuarios.setLayout(painelListaUsuariosLayout);
        painelListaUsuariosLayout.setHorizontalGroup(
            painelListaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelListaUsuariosLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(labelListaUsuarios)
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(painelListaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelListaUsuariosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollLlistaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        painelListaUsuariosLayout.setVerticalGroup(
            painelListaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelListaUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelListaUsuarios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(painelListaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelListaUsuariosLayout.createSequentialGroup()
                    .addContainerGap(69, Short.MAX_VALUE)
                    .addComponent(scrollLlistaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        areaTextoLogServidor.setColumns(20);
        areaTextoLogServidor.setRows(5);
        painelScrollLogServidor.setViewportView(areaTextoLogServidor);

        labelLogServidor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelLogServidor.setText("Log Servidor");

        javax.swing.GroupLayout painelLogServidorLayout = new javax.swing.GroupLayout(painelLogServidor);
        painelLogServidor.setLayout(painelLogServidorLayout);
        painelLogServidorLayout.setHorizontalGroup(
            painelLogServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLogServidorLayout.createSequentialGroup()
                .addContainerGap(194, Short.MAX_VALUE)
                .addComponent(labelLogServidor)
                .addGap(176, 176, 176))
            .addGroup(painelLogServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelLogServidorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painelScrollLogServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        painelLogServidorLayout.setVerticalGroup(
            painelLogServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLogServidorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogServidor)
                .addContainerGap(409, Short.MAX_VALUE))
            .addGroup(painelLogServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLogServidorLayout.createSequentialGroup()
                    .addContainerGap(67, Short.MAX_VALUE)
                    .addComponent(painelScrollLogServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        butaoStartServidor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        butaoStartServidor.setText("Start");
        butaoStartServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoStartServidorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelServidorLayout = new javax.swing.GroupLayout(painelServidor);
        painelServidor.setLayout(painelServidorLayout);
        painelServidorLayout.setHorizontalGroup(
            painelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelServidorLayout.createSequentialGroup()
                .addComponent(painelListaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(painelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelServidorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(butaoStartServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(painelLogServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        painelServidorLayout.setVerticalGroup(
            painelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelServidorLayout.createSequentialGroup()
                .addGroup(painelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelLogServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelListaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butaoStartServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelRaiz.add(painelServidor, "telaServidor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelRaiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelRaiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoJogarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoJogarLoginActionPerformed
        CardLayout c1 = (CardLayout) painelRaiz.getLayout();
                    
        if(campoNomeUsuario.getText().equals("servidorIFCE2021")){
            c1.show(painelRaiz, "telaServidor");
            setTitle("Surakarta - Painel de Administrador - Servidor OFFLINE");
            msgLogServidor += "O servidor ainda est� OFFLINE" + "\n";
            msgLogServidor += "Aguardando Start do servidor...\n" + "\n";

            areaTextoLogServidor.setText(msgLogServidor);
        }else{
            c1.show(painelRaiz, "telaPrincipal");
            
            String nomeUsuario = campoNomeUsuario.getText();
            usuario = new UsuarioControl(nomeUsuario);
            
            setTitle("Surakarta - " + campoNomeUsuario.getText() + " estamos aguardando um oponente para jogar com você");
            
            if (true) {
                JOptionPane.showMessageDialog(painelPrincipal, "Bem vindo " + campoNomeUsuario.getText() + ", \n\nVamos aguarda um oponente para jogar com você!", "Você está conectado", INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(painelPrincipal, "Você ainda não está conctado, talvez o Servidor esteja fora do ar.", "Conexão com servidor",ERROR_MESSAGE );
            }
        }

        
        campoTextoChat.requestFocus();
    }//GEN-LAST:event_botaoJogarLoginActionPerformed

    private void campoNomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeUsuarioActionPerformed

    private void botaoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEnviarActionPerformed
        if (!campoTextoChat.getText().equals("")) {
            usuario.setMsgEnviar(campoTextoChat.getText());
            chat += campoTextoChat.getText() + "\n";
            areaTextoChat.setText(chat);
            campoTextoChat.setText("");
        }
        campoTextoChat.requestFocus();
    }//GEN-LAST:event_botaoEnviarActionPerformed

    private void butaoStartServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoStartServidorActionPerformed
        servidor = new Servidor();
        msgLogServidor = "";
        areaTextoLogServidor.setText(servidor.getMsgStatus());
        
        if(servidor.isConectado()){
            butaoStartServidor.setName("Finish");
            setTitle("Surakarta - Painel de Administrador - Servidor ONLINE");
        }else if(butaoStartServidor.getName().equals("Finish")){
            servidor.fechar();
        }
        
    }//GEN-LAST:event_butaoStartServidorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(janelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(janelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(janelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(janelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new janelaJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTextoChat;
    private javax.swing.JTextArea areaTextoLogServidor;
    private javax.swing.JButton botaoEnviar;
    private javax.swing.JButton botaoJogarLogin;
    private javax.swing.JButton butaoStartServidor;
    private javax.swing.JTextField campoNomeUsuario;
    private javax.swing.JTextField campoTextoChat;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelListaUsuarios;
    private javax.swing.JLabel labelLogServidor;
    private javax.swing.JLabel labelNomeUsuarioLogin;
    private javax.swing.JList<String> listaUsuarios;
    private javax.swing.JPanel painelChat;
    private javax.swing.JPanel painelFormularioLogin;
    private javax.swing.JPanel painelJogo;
    private javax.swing.JPanel painelListaUsuarios;
    private javax.swing.JPanel painelLogServidor;
    private javax.swing.JPanel painelLogin;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelRaiz;
    private javax.swing.JScrollPane painelScrollLogServidor;
    private javax.swing.JPanel painelServidor;
    private javax.swing.JScrollPane scrollLlistaUsuarios;
    // End of variables declaration//GEN-END:variables
}
