package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class JpDespesa extends JPanel {
	private JButton btnAddDespesa;
	private JButton btnVoltar_despesa;
	private JTable table_despesas;
	private JPanel panel_principal_despesas;
	private JLabel lblDashboard;

	public JpDespesa() {
		this.setBackground(UIManager.getColor("ArrowButton.background"));
		// TODO Auto-generated constructor stub
		this.setName("");
		this.setLayout(null);
		add(getPanel_principal_despesas());
		add(getBtnAddDespesa());
		add(getBtnVoltar_despesa());
		add(getTable_despesas());
	}
	public JButton getBtnAddDespesa() {
		if (btnAddDespesa == null) {
			btnAddDespesa = new JButton("Nova despesa");
			btnAddDespesa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnAddDespesa.setBounds(194, 287, 136, 23);
		}
		return btnAddDespesa;
	}
	public JButton getBtnVoltar_despesa() {
		if (btnVoltar_despesa == null) {
			btnVoltar_despesa = new JButton("Voltar");
			btnVoltar_despesa.setBounds(340, 287, 89, 23);
		}
		return btnVoltar_despesa;
	}
	public JTable getTable_despesas() {
		if (table_despesas == null) {
			table_despesas = new JTable();
			table_despesas.setBounds(17, 73, 564, 203);
		}
		return table_despesas;
	}
	public JPanel getPanel_principal_despesas() {
		if (panel_principal_despesas == null) {
			panel_principal_despesas = new JPanel();
			panel_principal_despesas.setLayout(null);
			panel_principal_despesas.setBackground(new Color(119, 104, 255));
			panel_principal_despesas.setBounds(0, 0, 601, 62);
			panel_principal_despesas.add(getLblDashboard());
		}
		return panel_principal_despesas;
	}
	public JLabel getLblDashboard() {
		if (lblDashboard == null) {
			lblDashboard = new JLabel("Despesas");
			lblDashboard.setForeground(Color.WHITE);
			lblDashboard.setFont(new Font("Arial", Font.PLAIN, 22));
			lblDashboard.setBackground((Color) null);
			lblDashboard.setBounds(31, 20, 149, 31);
		}
		return lblDashboard;
	}
	public void setBtnAddDespesa(JButton btnAddDespesa) {
		this.btnAddDespesa = btnAddDespesa;
	}
	
}
