package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controller.UsuarioControl;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author raulmagalhaes
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    UsuarioControl usuario = new UsuarioControl();
    String chat = "";
    
    public JanelaPrincipal() {
        initComponents();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelGeral = new javax.swing.JPanel();
        painelInicial = new javax.swing.JPanel();
        btnJogar = new javax.swing.JButton();
        campoNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        painelPrincipal = new javax.swing.JPanel();
        painelChat = new javax.swing.JPanel();
        campoEnviar = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoChat = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        painelJogo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelGeral.setLayout(new java.awt.CardLayout());

        btnJogar.setText("Jogar");
        btnJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogarActionPerformed(evt);
            }
        });

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });
        campoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNomeKeyPressed(evt);
            }
        });

        jLabel1.setText("Nome:");

        javax.swing.GroupLayout painelInicialLayout = new javax.swing.GroupLayout(painelInicial);
        painelInicial.setLayout(painelInicialLayout);
        painelInicialLayout.setHorizontalGroup(
            painelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInicialLayout.createSequentialGroup()
                .addGroup(painelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelInicialLayout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(btnJogar))
                    .addGroup(painelInicialLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        painelInicialLayout.setVerticalGroup(
            painelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelInicialLayout.createSequentialGroup()
                .addContainerGap(320, Short.MAX_VALUE)
                .addGroup(painelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnJogar)
                .addGap(146, 146, 146))
        );

        painelGeral.add(painelInicial, "telaInicial");

        painelChat.setBorder(new javax.swing.border.SoftBevelBorder(1));

        campoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEnviarActionPerformed(evt);
            }
        });
        campoEnviar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoEnviarKeyPressed(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        textoChat.setEditable(false);
        textoChat.setColumns(20);
        textoChat.setRows(5);
        textoChat.setBorder(null);
        jScrollPane2.setViewportView(textoChat);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Conversa");

        javax.swing.GroupLayout painelChatLayout = new javax.swing.GroupLayout(painelChat);
        painelChat.setLayout(painelChatLayout);
        painelChatLayout.setHorizontalGroup(
            painelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelChatLayout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(campoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEnviar)))
                .addContainerGap())
            .addGroup(painelChatLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelChatLayout.setVerticalGroup(
            painelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelChatLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoEnviar))
                .addGap(18, 18, 18))
        );

        painelJogo.setBorder(new javax.swing.border.SoftBevelBorder(1));

        javax.swing.GroupLayout painelJogoLayout = new javax.swing.GroupLayout(painelJogo);
        painelJogo.setLayout(painelJogoLayout);
        painelJogoLayout.setHorizontalGroup(
            painelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );
        painelJogoLayout.setVerticalGroup(
            painelJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelGeral.add(painelPrincipal, "telaPrincipal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if (!campoEnviar.getText().equals("")) {
            usuario.setMsgEnviar(campoEnviar.getText());
            chat += usuario.getMsgEnviar() + "\n";
            textoChat.setText(chat);
            campoEnviar.setText("");
        }
        campoEnviar.requestFocus();
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnJogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogarActionPerformed
        usuario.setNomeUsuario(campoNome.getText());
        
        CardLayout c1 = (CardLayout) painelGeral.getLayout();
        c1.show(painelGeral, "telaPrincipal");
                    
        if (usuario.isConectado()) {
            JOptionPane.showMessageDialog(painelPrincipal, "Conectado. Bem vindo " + usuario.getNomeUsuario() + "!", "Conex�o com servidor", INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(painelPrincipal, "Servidor fora do ar", "Conex�o com servidor",ERROR_MESSAGE );
        }
        
        campoEnviar.requestFocus();
    }//GEN-LAST:event_btnJogarActionPerformed

    private void campoEnviarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoEnviarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !campoEnviar.getText().equals("")) {
            usuario.setMsgEnviar(campoEnviar.getText());
            chat += campoEnviar.getText() + "\n";
            textoChat.setText(chat);
            campoEnviar.setText("");
            campoEnviar.requestFocus();
        }
    }//GEN-LAST:event_campoEnviarKeyPressed

    private void campoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEnviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEnviarActionPerformed

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed

    }//GEN-LAST:event_campoNomeActionPerformed

    private void campoNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            usuario.setNomeUsuario(campoNome.getText());
            
            System.out.println("Esta pegando o nome do cliente. " + usuario.getNomeUsuario());
            
            CardLayout c1 = (CardLayout) painelGeral.getLayout();
            c1.show(painelGeral, "telaPrincipal");

            if (usuario.isConectado()) {
               JOptionPane.showMessageDialog(painelPrincipal, "Conectado. Bem vindo " + usuario.getNomeUsuario() + "!", "Conex�o com servidor", INFORMATION_MESSAGE);
            }else {
               JOptionPane.showMessageDialog(painelPrincipal, "Servidor fora do ar", "Conex�o com servidor",ERROR_MESSAGE );
            }
            
            campoEnviar.requestFocus();
        }
    }//GEN-LAST:event_campoNomeKeyPressed

    /*
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
        */
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnJogar;
    private javax.swing.JTextField campoEnviar;
    private javax.swing.JTextField campoNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painelChat;
    private javax.swing.JPanel painelGeral;
    private javax.swing.JPanel painelInicial;
    private javax.swing.JPanel painelJogo;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JTextArea textoChat;
    // End of variables declaration//GEN-END:variables
}
