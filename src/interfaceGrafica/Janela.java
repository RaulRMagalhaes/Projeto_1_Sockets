package interfaceGrafica;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Janela extends JFrame {
	
	public Janela() {
		setTitle("Aplicativo");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		JLabel label = new JLabel();
		label.setBounds(150,200,100,20);
		label.setText("Ola,mundo");
		label.setVisible(true);

		this.add(label);
	}
	
	public void setText() {
		//
	}
}

 
