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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

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
	private JpDespesa despesas;
	private JpReceita receitas;
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
	private JLabel lblsaldo_atual_valor;
	private JLabel lblreceitas_valor;
	private JLabel lbldespesas_valor;
	private JPanel panel_principal;
	private JLabel lbltotal_d;
	private JLabel lbltotal_d_1;
	private JTextField text_num_total_despesas;
	private JTextField text_num_total_receitas;
	private JTable table;
	private JLabel lbl_acompanhamento_geral;
	private JLabel lbl_icone_saldo;
	private JLabel lbl_icone_receitas;
	private JLabel lbl_icone_despesas;
	

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
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		tabbedPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(new Color(228, 228, 228));
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.addTab("Dashboard", null, getJPDashboard(), null);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 0));
		tabbedPane.addTab("Receitas", null, getJPReceitas(), null);
		tabbedPane.addTab("Despesas", null, getJPDespesas(), null);
	}



	public JpDashboard getJPDashboard() {
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
			dashboard.add(getTable());
			dashboard.add(getLbl_acompanhamento_geral());
		}
		return dashboard;
	}

	public JpDespesa getJPDespesas() {
		if (despesas == null) {
			despesas = new JpDespesa();
			despesas.getPanel_principal_despesas().setBounds(0, 0, 623, 62);
			despesas.getBtnAddDespesa().addActionListener(this);
		}
		return despesas;
	}
	
	public JpReceita getJPReceitas() {
		if (receitas == null) {
			receitas = new JpReceita();
			receitas.getPanel_principal_receitas().setBounds(0, 0, 623, 62);
			receitas.getBtnNovaReceita().addActionListener(this);
		}
		return receitas;
	}
	public JPanel getPanel_saldo_atual() {
		if (panel_saldo_atual == null) {
			panel_saldo_atual = new JPanel();
			panel_saldo_atual.setBackground(Color.WHITE);
			panel_saldo_atual.setBounds(28, 73, 168, 67);
			panel_saldo_atual.setLayout(null);
			panel_saldo_atual.add(getLbl_saldo_atual());
			panel_saldo_atual.add(getLbl_RS1());
			panel_saldo_atual.add(getLblsaldo_atual_valor());
			panel_saldo_atual.add(getLbl_icone_saldo());
		}
		return panel_saldo_atual;
	}
	public JLabel getLbl_saldo_atual() {
		if (lbl_saldo_atual == null) {
			lbl_saldo_atual = new JLabel("Saldo Atual:");
			lbl_saldo_atual.setBounds(5, 8, 59, 13);
			lbl_saldo_atual.setForeground(Color.DARK_GRAY);
			lbl_saldo_atual.setFont(new Font("Arial", Font.BOLD, 10));
			lbl_saldo_atual.setVerticalAlignment(SwingConstants.TOP);
			lbl_saldo_atual.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lbl_saldo_atual;
	}
	public JPanel getPanel_receitas() {
		if (panel_receitas == null) {
			panel_receitas = new JPanel();
			panel_receitas.setBorder(UIManager.getBorder("List.cellNoFocusBorder"));
			panel_receitas.setBackground(Color.WHITE);
			panel_receitas.setBounds(208, 73, 169, 67);
			panel_receitas.setLayout(null);
			panel_receitas.add(getLbl_receitas());
			panel_receitas.add(getLbl_RS1_1());
			panel_receitas.add(getLblreceitas_valor());
			panel_receitas.add(getLbl_icone_receitas());
		}
		return panel_receitas;
	}
	public JLabel getLbl_receitas() {
		if (lbl_receitas == null) {
			lbl_receitas = new JLabel("Receitas:");
			lbl_receitas.setBounds(5, 5, 56, 13);
			lbl_receitas.setForeground(Color.DARK_GRAY);
			lbl_receitas.setVerticalAlignment(SwingConstants.TOP);
			lbl_receitas.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_receitas.setFont(new Font("Arial", Font.BOLD, 10));
		}
		return lbl_receitas;
	}
	public JPanel getPanel_despesas() {
		if (panel_despesas == null) {
			panel_despesas = new JPanel();
			panel_despesas.setBorder(UIManager.getBorder("List.cellNoFocusBorder"));
			panel_despesas.setBackground(Color.WHITE);
			panel_despesas.setBounds(389, 73, 174, 67);
			panel_despesas.setLayout(null);
			panel_despesas.add(getLbl_despesas());
			panel_despesas.add(getLbl_RS1_1_1());
			panel_despesas.add(getLbldespesas_valor());
			panel_despesas.add(getLbl_icone_despesas());
		}
		return panel_despesas;
	}
	public JLabel getLbl_despesas() {
		if (lbl_despesas == null) {
			lbl_despesas = new JLabel("despesas:");
			lbl_despesas.setBounds(5, 5, 63, 13);
			lbl_despesas.setForeground(Color.DARK_GRAY);
			lbl_despesas.setVerticalAlignment(SwingConstants.TOP);
			lbl_despesas.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_despesas.setFont(new Font("Arial", Font.BOLD, 10));
		}
		return lbl_despesas;
	}
	public JLabel getLbl_RS1() {
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
	public JLabel getLblDashboard() {
		if (lbldashboard == null) {
			lbldashboard = new JLabel("dashboard");
			lbldashboard.setForeground(Color.WHITE);
			lbldashboard.setBackground(UIManager.getColor("nimbusLightBackground"));
			lbldashboard.setBounds(31, 20, 149, 31);
			lbldashboard.setFont(new Font("Arial", Font.PLAIN, 22));
		}
		return lbldashboard;
	}
	public JLabel getLbl_RS1_1() {
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
	public JLabel getLbl_RS1_1_1() {
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
	public JLabel getLblsaldo_atual_valor() {
		if (lblsaldo_atual_valor == null) {
			lblsaldo_atual_valor = new JLabel("00.00");
			lblsaldo_atual_valor.setFont(new Font("Arial", Font.PLAIN, 23));
			lblsaldo_atual_valor.setBounds(34, 32, 70, 24);
		}
		return lblsaldo_atual_valor;
	}
	public JLabel getLblreceitas_valor() {
		if (lblreceitas_valor == null) {
			lblreceitas_valor = new JLabel("00.00");
			lblreceitas_valor.setFont(new Font("Arial", Font.PLAIN, 23));
			lblreceitas_valor.setBounds(34, 33, 86, 24);
		}
		return lblreceitas_valor;
	}
	public JLabel getLbldespesas_valor() {
		if (lbldespesas_valor == null) {
			lbldespesas_valor = new JLabel("00.00");
			lbldespesas_valor.setFont(new Font("Arial", Font.PLAIN, 23));
			lbldespesas_valor.setBounds(34, 33, 86, 24);
		}
		return lbldespesas_valor;
	}
	public JPanel getPanel_principal() {
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
	public JLabel getLbltotal_d() {
		if (lbltotal_d == null) {
			lbltotal_d = new JLabel("N\u00FAmero total de despesas:\r\n");
			lbltotal_d.setFont(new Font("Arial", Font.PLAIN, 15));
			lbltotal_d.setBounds(38, 151, 199, 18);
		}
		return lbltotal_d;
	}
	public JLabel getLbltotal_d_1() {
		if (lbltotal_d_1 == null) {
			lbltotal_d_1 = new JLabel("N\u00FAmero total de receitas:\r\n");
			lbltotal_d_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lbltotal_d_1.setBounds(333, 151, 189, 18);
		}
		return lbltotal_d_1;
	}
	public JTextField getText_num_total_despesas() {
		if (text_num_total_despesas == null) {
			text_num_total_despesas = new JTextField();
			text_num_total_despesas.setEditable(false);
			text_num_total_despesas.setHorizontalAlignment(SwingConstants.CENTER);
			text_num_total_despesas.setFont(new Font("Arial", Font.PLAIN, 14));
			text_num_total_despesas.setText("00\r\n");
			text_num_total_despesas.setBounds(221, 151, 59, 20);
			text_num_total_despesas.setColumns(10);
		}
		return text_num_total_despesas;
	}
	public JTextField getText_num_total_receitas() {
		if (text_num_total_receitas == null) {
			text_num_total_receitas = new JTextField();
			text_num_total_receitas.setEditable(false);
			text_num_total_receitas.setHorizontalAlignment(SwingConstants.CENTER);
			text_num_total_receitas.setFont(new Font("Arial", Font.PLAIN, 14));
			text_num_total_receitas.setText("00\r\n");
			text_num_total_receitas.setColumns(10);
			text_num_total_receitas.setBounds(502, 151, 59, 20);
		}
		return text_num_total_receitas;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBounds(28, 213, 536, 118);
		}
		return table;
	}
	public JLabel getLbl_acompanhamento_geral() {
		if (lbl_acompanhamento_geral == null) {
			lbl_acompanhamento_geral = new JLabel("Acompanhamento geral:");
			lbl_acompanhamento_geral.setFont(new Font("Arial", Font.PLAIN, 15));
			lbl_acompanhamento_geral.setBounds(195, 194, 199, 18);
		}
		return lbl_acompanhamento_geral;
	}
	public JLabel getLbl_icone_saldo() {
		if (lbl_icone_saldo == null) {
			lbl_icone_saldo = new JLabel("");
			lbl_icone_saldo.setIcon(new ImageIcon("C:\\Users\\Iago Ramon\\eclipse-workspace\\LP3_Trabalho1\\Imagens\\saldo atual.png"));
			lbl_icone_saldo.setBounds(114, 18, 44, 38);
		}
		return lbl_icone_saldo;
	}
	public JLabel getLbl_icone_receitas() {
		if (lbl_icone_receitas == null) {
			lbl_icone_receitas = new JLabel("");
			lbl_icone_receitas.setIcon(new ImageIcon("C:\\Users\\Iago Ramon\\eclipse-workspace\\LP3_Trabalho1\\Imagens\\receitas.png"));
			lbl_icone_receitas.setBounds(115, 18, 44, 38);
		}
		return lbl_icone_receitas;
	}
	public JLabel getLbl_icone_despesas() {
		if (lbl_icone_despesas == null) {
			lbl_icone_despesas = new JLabel("");
			lbl_icone_despesas.setIcon(new ImageIcon("C:\\Users\\Iago Ramon\\eclipse-workspace\\LP3_Trabalho1\\Imagens\\despesas.png"));
			lbl_icone_despesas.setBounds(120, 18, 44, 38);
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
		
		Arquivos.addDespesa(Despesa.getCadDespesa());
		Arquivos.addReceita(Receita.getReceita());
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
