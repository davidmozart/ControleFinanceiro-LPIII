package visao;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JpReceita extends JPanel {
	private JPanel panel_principal_receitas;
	private JLabel lblReceitas;
	private JTable table_receitas;
	private JButton btnNovaReceita;
	private JButton btnVoltar_despesa;

	public JpReceita() {
		// TODO Auto-generated constructor stub
		this.setName("");
		this.setLayout(null);
		add(getPanel_principal_receitas());
		add(getTable_receitas());
		add(getBtnNovaReceita());
		add(getBtnVoltar_despesa());
	}

	public JPanel getPanel_principal_receitas() {
		if (panel_principal_receitas == null) {
			panel_principal_receitas = new JPanel();
			panel_principal_receitas.setLayout(null);
			panel_principal_receitas.setBackground(new Color(119, 104, 255));
			panel_principal_receitas.setBounds(0, 0, 601, 62);
			panel_principal_receitas.add(getLblReceitas());
		}
		return panel_principal_receitas;
	}
	public JLabel getLblReceitas() {
		if (lblReceitas == null) {
			lblReceitas = new JLabel("Receitas");
			lblReceitas.setForeground(Color.WHITE);
			lblReceitas.setFont(new Font("Arial", Font.PLAIN, 22));
			lblReceitas.setBackground((Color) null);
			lblReceitas.setBounds(31, 20, 149, 31);
		}
		return lblReceitas;
	}
	public JTable getTable_receitas() {
		if (table_receitas == null) {
			table_receitas = new JTable();
			table_receitas.setBounds(20, 73, 558, 203);
		}
		return table_receitas;
	}
	public JButton getBtnNovaReceita() {
		if (btnNovaReceita == null) {
			btnNovaReceita = new JButton("Nova receita");
			btnNovaReceita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNovaReceita.setBounds(199, 294, 112, 23);
		}
		return btnNovaReceita;
	}
	public JButton getBtnVoltar_despesa() {
		if (btnVoltar_despesa == null) {
			btnVoltar_despesa = new JButton("Voltar");
			btnVoltar_despesa.setBounds(321, 294, 89, 23);
		}
		return btnVoltar_despesa;
	}
}