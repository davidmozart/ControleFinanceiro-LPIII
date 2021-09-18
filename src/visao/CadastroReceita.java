package visao;

import java.awt.Dimension;

import javax.swing.JFrame;

public class CadastroReceita extends JFrame{

	private static final long serialVersionUID = 1L;

	public CadastroReceita() {
		setResizable(false);
		setSize(new Dimension(550, 385));
		setLocationRelativeTo(null);
		setTitle("Cadastro de receita");

		repaint();
		validate();
		setVisible(true);
	}

	
}
