package visao;

import java.awt.Dimension;

import javax.swing.JFrame;

public class CadastroDespesa extends JFrame {

	private static final long serialVersionUID = 1L;

	public CadastroDespesa() {
		setResizable(false);
		setSize(new Dimension(550, 385));
		setLocationRelativeTo(null);
		setTitle("Cadastro de despesa");

		repaint();
		validate();
		setVisible(true);
		//this.setDefaultCloseOperation(CadastroDespesa.HIDE_ON_CLOSE);
	}

	
}

