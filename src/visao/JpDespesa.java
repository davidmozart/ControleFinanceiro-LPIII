package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class JpDespesa extends JPanel {
	private JButton btnAddDespesa;
	private JScrollPane scrollPane;
	private JPanel panel_principal_despesas;
	private JLabel lblDashboard;
	private JTable table_despesas;

	public JpDespesa() {
		this.setBackground(UIManager.getColor("ArrowButton.background"));
		// TODO Auto-generated constructor stub
		this.setName("");
		this.setLayout(null);
		add(getPanel_principal_despesas());
		add(getBtnAddDespesa());
		add(getScrollPane());
	}
		
		public JTable getTable_despesas() {
			if (table_despesas == null) {
				table_despesas = new JTable();
				table_despesas.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID", "Descri\u00E7\u00E3o", "Data", "Valor"
					}
				) {
					Class[] columnTypes = new Class[] {
						Integer.class, String.class, String.class, Double.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					boolean[] columnEditables = new boolean[] {
						false, true, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
			}
			return table_despesas;
	}
	public JButton getBtnAddDespesa() {
		if (btnAddDespesa == null) {
			btnAddDespesa = new JButton("Nova despesa");
			btnAddDespesa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnAddDespesa.setBounds(236, 287, 136, 23);
		}
		return btnAddDespesa;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 81, 584, 194);
			scrollPane.setViewportView(getTable_despesas());
		}
		return scrollPane;
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
