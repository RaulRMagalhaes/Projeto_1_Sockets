package interfaceGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JanelaUsuario extends JFrame{
	
	JLabel label = new JLabel();
	JTextArea textoEntrada = new JTextArea();
	JTextField textoSaida = new JTextField();
	JButton btnEnviar = new JButton("Enviar");
	String msgEntrada = "";
	String msgSaida = "";
	String nomeUsuario;
	int Pontos;

	
	public JanelaUsuario(String nomeUsuario) {
		setTitle("Aplicativo - " + nomeUsuario);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		
		label.setBounds(350,100,100,20);
		label.setText("CHAT:");
		label.setVisible(true);
		add(label);
		
		textoEntrada.setBounds(20,200,400,200);
		textoEntrada.setVisible(true);
		add(textoEntrada);
		
		textoSaida.setBounds(20,500,400,20);
		textoSaida.setVisible(true);
		add(textoSaida);
		
		btnEnviar.setBounds(510,500,100,30);
		btnEnviar.setVisible(true);
		add(btnEnviar);
		
		btnEnviar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				msgSaida = textoSaida.getText();
				textoSaida.setText("");
			}	
		});
	}
	
	public void setTextoEntrada(String text) {
		msgEntrada += "\n" + text;
		textoEntrada.setText(msgEntrada);
	}
	
	public String getTextoSaida() {
		return msgSaida;
	}
	
}

 
