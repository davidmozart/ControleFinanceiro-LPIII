package controle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import dados.Arquivos;
import modelo.Despesa;
import modelo.Receita;
import visao.JanelaPrincipal;
import visao.JpDashboard;
import visao.JpDespesa;
import visao.JpReceita;

public class ControladorPrincipal extends JanelaPrincipal implements ActionListener, WindowListener {
	
	
	private static final long serialVersionUID = 1L;
	
	private static ControladorPrincipal instancia;	
	
	private JpDashboard dashboard;
	private static JpDespesa despesas;
	private static JpReceita receitas;
	private JPanel panel_saldo_atual;
	private JLabel lbl_saldo_atual;
	private JPanel panel_receitas;
	private JLabel lbl_receitas;
	private JPanel panel_despesas;
	private JLabel lbl_despesas;
	private JLabel lbl_RS1;
	private JLabel lbldashboard;
	private JLabel lbl_RS1_1;
	private JLabel lbl_RS1_1_1;
	private static JTextField txtSaldo_atual_valor;
	private static JTextField txtReceitas_valor;
	private static JTextField txtDespesas_valor;
	private JPanel panel_principal;
	private JLabel lbltotal_d;
	private JLabel lbltotal_d_1;
	private static JTextField text_num_total_despesas;
	private static JTextField text_num_total_receitas;
	private JLabel lbl_icone_saldo;
	private JLabel lbl_icone_receitas;
	private JLabel lbl_icone_despesas;
	private JTabbedPane guiaPaineis;
	private static double somaDespesa;
	private static double somaReceita;

	private ControladorPrincipal() {
		addEventos();
	}
	
	public static synchronized ControladorPrincipal getInstance() {
		if (instancia == null) {
			instancia = new ControladorPrincipal();
			instancia.addWindowListener(instancia);
		} 
		return instancia;
	}
	
	public void addEventos() {
		getGuiaPaineis();		
		Arquivos.readDespesa();
		Arquivos.readReceita();
		addTabelaReceita();
		addTabelaDespesa();
		calculoDashboard();
		
	}
	
	private void calculoDashboard() {
		getTxtReceitas_valor().setText(String.format("%.2f", somaReceita));
		getTxtDespesas_valor().setText(String.format("%.2f", somaDespesa));
		getTxtSaldo_atual_valor().setText(String.format("%.2f", somaReceita-somaDespesa));
		getText_num_total_despesas().setText(String.valueOf(Despesa.getCadDespesa().size()));
		getText_num_total_receitas().setText(String.valueOf(Receita.getReceita().size()));
	}

	private JTabbedPane getGuiaPaineis() {
			guiaPaineis = new JTabbedPane(JTabbedPane.LEFT);
			guiaPaineis.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			guiaPaineis.setAlignmentX(Component.LEFT_ALIGNMENT);
			guiaPaineis.setBorder(null);
			guiaPaineis.setBackground(new Color(228, 228, 228));
			this.getContentPane().add(guiaPaineis, BorderLayout.CENTER);
			guiaPaineis.addTab("Dashboard", null, getJPDashboard(), null);
			guiaPaineis.setForegroundAt(0, new Color(0, 0, 0));
			guiaPaineis.addTab("Receitas", null, getJPReceitas(), null);
			guiaPaineis.addTab("Despesas", null, getJPDespesas(), null);
		return guiaPaineis;
	}

	private JpDashboard getJPDashboard() {
		if (dashboard == null) {
			dashboard = new JpDashboard();
			dashboard.add(getPanel_saldo_atual());
			dashboard.add(getPanel_receitas());
			dashboard.add(getPanel_despesas());
			dashboard.add(getPanel_principal());
			dashboard.add(getLbltotal_d());
			dashboard.add(getLbltotal_d_1());
			dashboard.add(getText_num_total_despesas());
			dashboard.add(getText_num_total_receitas());
		}
		return dashboard;
	}
	
	
	
	private JpDespesa getJPDespesas() {
		if (despesas == null) {
			despesas = new JpDespesa();
			despesas.getTable_despesas().setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID", "Descrição", "Data", "Valor"
					}
				) {
					
					private static final long serialVersionUID = 1L;
					Class[] columnTypes = new Class[] {
						Integer.class, String.class, String.class, Double.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					boolean[] columnEditables = new boolean[] {
						false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
			despesas.getTable_despesas().setBounds(23, 73, 571, 203);
			despesas.getPanel_principal_despesas().setBounds(0, 0, 623, 62);
			despesas.getBtnAddDespesa().addActionListener(this);
		}
		return despesas;
	}
	
	private void addTabelaDespesa() {
		DefaultTableModel modelo = (DefaultTableModel) despesas.getTable_despesas()
				.getModel();
		for(Despesa rec : Despesa.getCadDespesa()) {
			modelo.addRow(new Object[] {rec.getId()
					, rec.getDescricao()
					, rec.getData()
					, rec.getValor()});
			somaDespesa += rec.getValor();
		}
	}
	
	public static void addTabelaDespesaCad(Integer id, String descricao, String data, Double valor) {
		DefaultTableModel modelo = (DefaultTableModel) despesas.getTable_despesas()
				.getModel();
		modelo.addRow(new Object[] {id, descricao, data, valor});
		somaDespesa += valor;
		getTxtDespesas_valor().setText(String.valueOf(somaDespesa));
		getTxtSaldo_atual_valor().setText(String.format("%.2f", somaReceita-somaDespesa));
		getText_num_total_despesas().setText(String.valueOf(Despesa.getCadDespesa().size()));
	}
	
	private JpReceita getJPReceitas() {
		if (receitas == null) {
			receitas = new JpReceita();
			receitas.getScrollPane().setBounds(10, 74, 584, 204);
			receitas.getTable_receitas().setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Descrição", "Data", "Valor"
				}
			) {
				
				private static final long serialVersionUID = 1L;
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, Double.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			receitas.getBtnNovaReceita().setSize(131, 23);
			receitas.getBtnNovaReceita().setLocation(238, 290);
			receitas.getTable_receitas().setBounds(23, 73, 571, 203);
			receitas.getPanel_principal_receitas().setBounds(0, 0, 594, 62);
			receitas.getBtnNovaReceita().addActionListener(this);
		}		
		return receitas;
	}
	public void addTabelaReceita() {
		DefaultTableModel modelo = (DefaultTableModel) receitas.getTable_receitas()
				.getModel();
		for(Receita rec : Receita.getReceita()) {
			modelo.addRow(new Object[] {rec.getId()
					, rec.getDescricao()
					, rec.getData()
					, rec.getValor()});
			somaReceita += rec.getValor();
		}
	}
	public static void addTabelaReceitaCad(Integer id, String descricao, String data, Double valor) {
		DefaultTableModel modelo = (DefaultTableModel) receitas.getTable_receitas()
				.getModel();
		modelo.addRow(new Object[] {id, descricao, data, valor});
		somaReceita += valor;
		getTxtReceitas_valor().setText(String.valueOf(somaReceita));
		getTxtSaldo_atual_valor().setText(String.format("%.2f", somaReceita-somaDespesa));
		getText_num_total_receitas().setText(String.valueOf(Receita.getReceita().size()));
	}
	
	private JPanel getPanel_saldo_atual() {
		if (panel_saldo_atual == null) {
			panel_saldo_atual = new JPanel();
			panel_saldo_atual.setBackground(Color.WHITE);
			panel_saldo_atual.setBounds(27, 73, 249, 80);
			panel_saldo_atual.setLayout(null);
			panel_saldo_atual.add(getLbl_saldo_atual());
			panel_saldo_atual.add(getLbl_RS1());
			panel_saldo_atual.add(getLbl_icone_saldo());
			panel_saldo_atual.add(getTxtSaldo_atual_valor());
		}
		return panel_saldo_atual;
	}
	
	private JLabel getLbl_saldo_atual() {
		if (lbl_saldo_atual == null) {
			lbl_saldo_atual = new JLabel("Saldo Atual:");
			lbl_saldo_atual.setBounds(5, 8, 113, 20);
			lbl_saldo_atual.setForeground(Color.DARK_GRAY);
			lbl_saldo_atual.setFont(new Font("Dialog", Font.BOLD, 16));
			lbl_saldo_atual.setVerticalAlignment(SwingConstants.TOP);
			lbl_saldo_atual.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lbl_saldo_atual;
	}
	
	private JPanel getPanel_receitas() {
		if (panel_receitas == null) {
			panel_receitas = new JPanel();
			panel_receitas.setBorder(UIManager.getBorder("List.cellNoFocusBorder"));
			panel_receitas.setBackground(Color.WHITE);
			panel_receitas.setBounds(27, 165, 249, 80);
			panel_receitas.setLayout(null);
			panel_receitas.add(getLbl_receitas());
			panel_receitas.add(getLbl_RS1_1());
			panel_receitas.add(getLbl_icone_receitas());
			panel_receitas.add(getTxtReceitas_valor());
		}
		return panel_receitas;
	}
	
	private JLabel getLbl_receitas() {
		if (lbl_receitas == null) {
			lbl_receitas = new JLabel("Receitas:");
			lbl_receitas.setBounds(5, 5, 88, 23);
			lbl_receitas.setForeground(Color.DARK_GRAY);
			lbl_receitas.setVerticalAlignment(SwingConstants.TOP);
			lbl_receitas.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_receitas.setFont(new Font("Dialog", Font.BOLD, 16));
		}
		return lbl_receitas;
	}
	
	private JPanel getPanel_despesas() {
		if (panel_despesas == null) {
			panel_despesas = new JPanel();
			panel_despesas.setBorder(UIManager.getBorder("List.cellNoFocusBorder"));
			panel_despesas.setBackground(Color.WHITE);
			panel_despesas.setBounds(27, 257, 249, 79);
			panel_despesas.setLayout(null);
			panel_despesas.add(getLbl_despesas());
			panel_despesas.add(getLbl_RS1_1_1());
			panel_despesas.add(getLbl_icone_despesas());
			panel_despesas.add(getTxtDespesas_valor());
		}
		return panel_despesas;
	}
	
	private JLabel getLbl_despesas() {
		if (lbl_despesas == null) {
			lbl_despesas = new JLabel("despesas:");
			lbl_despesas.setBounds(5, 5, 97, 23);
			lbl_despesas.setForeground(Color.DARK_GRAY);
			lbl_despesas.setVerticalAlignment(SwingConstants.TOP);
			lbl_despesas.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_despesas.setFont(new Font("Dialog", Font.BOLD, 16));
		}
		return lbl_despesas;
	}
	
	private JLabel getLbl_RS1() {
		if (lbl_RS1 == null) {
			lbl_RS1 = new JLabel("R$:");
			lbl_RS1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_RS1.setBounds(5, 40, 19, 16);
			lbl_RS1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			lbl_RS1.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_RS1.setVerticalAlignment(SwingConstants.BOTTOM);
		}
		return lbl_RS1;
	}
	
	private JLabel getLblDashboard() {
		if (lbldashboard == null) {
			lbldashboard = new JLabel("dashboard");
			lbldashboard.setForeground(Color.WHITE);
			lbldashboard.setBackground(UIManager.getColor("nimbusLightBackground"));
			lbldashboard.setBounds(31, 20, 149, 31);
			lbldashboard.setFont(new Font("Arial", Font.PLAIN, 22));
		}
		return lbldashboard;
	}
	
	private JLabel getLbl_RS1_1() {
		if (lbl_RS1_1 == null) {
			lbl_RS1_1 = new JLabel("R$:");
			lbl_RS1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_RS1_1.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_RS1_1.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_RS1_1.setAlignmentY(1.0f);
			lbl_RS1_1.setBounds(5, 40, 19, 16);
		}
		return lbl_RS1_1;
	}
	
	private JLabel getLbl_RS1_1_1() {
		if (lbl_RS1_1_1 == null) {
			lbl_RS1_1_1 = new JLabel("R$:");
			lbl_RS1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_RS1_1_1.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_RS1_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_RS1_1_1.setAlignmentY(1.0f);
			lbl_RS1_1_1.setBounds(5, 40, 19, 16);
		}
		return lbl_RS1_1_1;
	}
	
	private static JTextField getTxtSaldo_atual_valor() {
		if (txtSaldo_atual_valor == null) {
			txtSaldo_atual_valor = new JTextField("");
			txtSaldo_atual_valor.setBounds(21, 33, 137, 24);
			txtSaldo_atual_valor.setEditable(false);
			txtSaldo_atual_valor.setFont(new Font("Dialog", Font.PLAIN, 18));
		}
		return txtSaldo_atual_valor;
	}
	
	private static JTextField getTxtReceitas_valor() {
		if (txtReceitas_valor == null) {
			txtReceitas_valor = new JTextField("");
			txtReceitas_valor.setBounds(20, 33, 163, 24);
			txtReceitas_valor.setSelectionColor(Color.WHITE);
			txtReceitas_valor.setDisabledTextColor(Color.WHITE);
			txtReceitas_valor.setEditable(false);
			txtReceitas_valor.setFont(new Font("Dialog", Font.PLAIN, 18));
		}
		return txtReceitas_valor;
	}
	
	
	private static JTextField getTxtDespesas_valor() {
		if (txtDespesas_valor == null) {
			txtDespesas_valor = new JTextField("");
			txtDespesas_valor.setBounds(20, 32, 161, 24);
			txtDespesas_valor.setDisabledTextColor(Color.WHITE);
			txtDespesas_valor.setSelectionColor(Color.WHITE);
			txtDespesas_valor.setEditable(false);
			txtDespesas_valor.setFont(new Font("Dialog", Font.PLAIN, 18));
			
		}
		return txtDespesas_valor;
	}
	
	private JPanel getPanel_principal() {
		if (panel_principal == null) {
			panel_principal = new JPanel();
			panel_principal.setBackground(UIManager.getColor("nimbusFocus"));
			panel_principal.setBackground(new Color(119, 104, 255));
			panel_principal.setForeground(UIManager.getColor("Table.dropLineColor"));
			panel_principal.setBounds(0, 0, 621, 62);
			panel_principal.setLayout(null);
			panel_principal.add(getLblDashboard());
		}
		return panel_principal;
	}
	
	private JLabel getLbltotal_d() {
		if (lbltotal_d == null) {
			lbltotal_d = new JLabel("N\u00FAmero total de despesas:\r\n");
			lbltotal_d.setFont(new Font("Dialog", Font.BOLD, 16));
			lbltotal_d.setBounds(306, 77, 241, 18);
		}
		return lbltotal_d;
	}
	
	private JLabel getLbltotal_d_1() {
		if (lbltotal_d_1 == null) {
			lbltotal_d_1 = new JLabel("N\u00FAmero total de receitas:\r\n");
			lbltotal_d_1.setFont(new Font("Dialog", Font.BOLD, 16));
			lbltotal_d_1.setBounds(306, 225, 241, 18);
		}
		return lbltotal_d_1;
	}
	
	private static JTextField getText_num_total_despesas() {
		if (text_num_total_despesas == null) {
			text_num_total_despesas = new JTextField();
			text_num_total_despesas.setSelectionColor(Color.WHITE);
			text_num_total_despesas.setDisabledTextColor(Color.WHITE);
			text_num_total_despesas.setEditable(false);
			text_num_total_despesas.setHorizontalAlignment(SwingConstants.CENTER);
			text_num_total_despesas.setFont(new Font("Dialog", Font.PLAIN, 17));
			text_num_total_despesas.setBounds(316, 107, 212, 26);
			text_num_total_despesas.setColumns(10);
		}
		return text_num_total_despesas;
	}
	
	private static JTextField getText_num_total_receitas() {
		if (text_num_total_receitas == null) {
			text_num_total_receitas = new JTextField();
			text_num_total_receitas.setDisabledTextColor(Color.WHITE);
			text_num_total_receitas.setSelectionColor(Color.WHITE);
			text_num_total_receitas.setEditable(false);
			text_num_total_receitas.setHorizontalAlignment(SwingConstants.CENTER);
			text_num_total_receitas.setFont(new Font("Dialog", Font.PLAIN, 17));
			text_num_total_receitas.setColumns(10);
			text_num_total_receitas.setBounds(316, 257, 212, 26);
		}
		return text_num_total_receitas;
	}
	
	private JLabel getLbl_icone_saldo() {
		if (lbl_icone_saldo == null) {
			lbl_icone_saldo = new JLabel("");
			lbl_icone_saldo.setIcon(new ImageIcon("/home/oem/eclipse-workspace/ControleFinanceiro-LPIII/Imagens/saldo atual.png"));
			lbl_icone_saldo.setBounds(180, 8, 44, 38);
		}
		return lbl_icone_saldo;
	}
	
	private JLabel getLbl_icone_receitas() {
		if (lbl_icone_receitas == null) {
			lbl_icone_receitas = new JLabel("");
			lbl_icone_receitas.setIcon(new ImageIcon("/home/oem/eclipse-workspace/ControleFinanceiro-LPIII/Imagens/receitas.png"));
			lbl_icone_receitas.setBounds(193, 5, 44, 38);
		}
		return lbl_icone_receitas;
	}
	
	private JLabel getLbl_icone_despesas() {
		if (lbl_icone_despesas == null) {
			lbl_icone_despesas = new JLabel("");
			lbl_icone_despesas.setIcon(new ImageIcon("/home/oem/eclipse-workspace/ControleFinanceiro-LPIII/Imagens/despesas.png"));
			lbl_icone_despesas.setBounds(193, 5, 44, 38);
		}
		return lbl_icone_despesas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == despesas.getBtnAddDespesa()) {
			ControleCadDespesa.getInstance();
		} else if(e.getSource() == receitas.getBtnNovaReceita()) {
			ControleCadReceita.getInstance();
		}
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
//		for(Receita r : Receita.getReceita()) {
//			//System.out.println(r.getId());
//		}
		Arquivos.addDespesa();
		Arquivos.addReceita();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		 
	}
}
