package visao;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {

	public JanelaPrincipal() {
		setResizable(false);
		setSize(new Dimension(700, 385));
		setLocationRelativeTo(null);
		setTitle("Iago Ramon - Trabalho de LP3");
		repaint();
		validate();
		setVisible(true);
		this.setDefaultCloseOperation(JanelaPrincipal.EXIT_ON_CLOSE);
	}
}
