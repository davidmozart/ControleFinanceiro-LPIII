package controle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import modelo.Despesa;
import visao.CadastroDespesa;

public class ControleCadDespesa extends CadastroDespesa implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static ControleCadDespesa instancia;
	private static ControladorPrincipal contPrin = ControladorPrincipal.getInstance();


	private Despesa despesa;
	private JPanel panel_cadastro_despesa;
	private JPanel panel_principal_despesas;
	private JLabel lblNovaDespesa;
	private JLabel lbl_codigo_despesa;
	private JLabel lbl_valor_despesa;
	private JLabel lbl_data_despesa;
	private JDateChooser dateChooser;
	private JButton btn_cadastrar_despesa;
	private JButton btn_cancelar_cadastro_despesa;
	private JLabel lbl_descricao_despesa;
	private JTextField text_descricao_despesa;
	private JTextField text_valor_despesa;
	private JTextField text_codigo_despesa;
	private JLabel lbl_icone_despesas;

	private ControleCadDespesa() {
		addEventos();
	}

	private void addEventos() {
		getContentPane().add(getPanel_cadastro_despesa());
	}

	public static synchronized ControleCadDespesa getInstance() {
		instancia = new ControleCadDespesa();
		instancia.addWindowListener(instancia);
		return instancia;
	}

	public JPanel getPanel_cadastro_despesa() {
		if (panel_cadastro_despesa == null) {
			panel_cadastro_despesa = new JPanel();
			panel_cadastro_despesa.setForeground(Color.WHITE);
			panel_cadastro_despesa.setBounds(0, 0, 557, 316);
			panel_cadastro_despesa.setLayout(null);
			panel_cadastro_despesa.add(getPanel_principal_despesas_2());
			// panel_cadastro_despesa.add(getLbl_codigo_despesa());
			panel_cadastro_despesa.add(getLbl_valor_despesa());
			panel_cadastro_despesa.add(getLbl_data_despesa());
			panel_cadastro_despesa.add(getBtn_cadastrar_despesa());
			panel_cadastro_despesa.add(getBtn_cancelar_cadastro_despesa());
			panel_cadastro_despesa.add(getLbl_descricao_despesa());
			panel_cadastro_despesa.add(getText_descricao_despesa());
			panel_cadastro_despesa.add(getText_valor_despesa());

			panel_cadastro_despesa.add(getDateChooser());
			// panel_cadastro_despesa.add(getText_codigo_despesa());
			// panel_cadastro_despesa.add(getDate_data_despesa());

		}
		return panel_cadastro_despesa;
	}

	public JPanel getPanel_principal_despesas_2() {
		if (panel_principal_despesas == null) {
			panel_principal_despesas = new JPanel();
			panel_principal_despesas.setLayout(null);
			panel_principal_despesas.setBackground(new Color(119, 104, 255));
			panel_principal_despesas.setBounds(0, 0, 557, 62);
			panel_principal_despesas.add(getLblDashboard_2());
			panel_principal_despesas.add(getLbl_icone_despesas());
		}
		return panel_principal_despesas;
	}

	public JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(194, 168, 131, 19);
		}
		return dateChooser;
	}


	public JLabel getLblDashboard_2() {
		if (lblNovaDespesa == null) {
			lblNovaDespesa = new JLabel("Nova despesa");
			lblNovaDespesa.setForeground(Color.WHITE);
			lblNovaDespesa.setFont(new Font("Arial", Font.PLAIN, 22));
			lblNovaDespesa.setBackground((Color) null);
			lblNovaDespesa.setBounds(31, 20, 149, 31);
		}
		return lblNovaDespesa;
	}

	public JLabel getLbl_codigo_despesa() {
		if (lbl_codigo_despesa == null) {
			lbl_codigo_despesa = new JLabel("C\u00F3digo da despesa:");
			lbl_codigo_despesa.setFont(new Font("Arial", Font.PLAIN, 13));
			lbl_codigo_despesa.setBounds(58, 95, 137, 14);
		}
		return lbl_codigo_despesa;
	}

	public JLabel getLbl_valor_despesa() {
		if (lbl_valor_despesa == null) {
			lbl_valor_despesa = new JLabel("Valor da despesa: ");
			lbl_valor_despesa.setFont(new Font("Arial", Font.PLAIN, 13));
			lbl_valor_despesa.setBounds(68, 133, 119, 14);
		}
		return lbl_valor_despesa;
	}

	public JLabel getLbl_data_despesa() {
		if (lbl_data_despesa == null) {
			lbl_data_despesa = new JLabel("Data da despesa: ");
			lbl_data_despesa.setFont(new Font("Arial", Font.PLAIN, 13));
			lbl_data_despesa.setBounds(69, 168, 119, 14);
		}
		return lbl_data_despesa;
	}

	/*
	 * public JDateChooser getDate_data_despesa() { 
	 * if (date_data_despesa == null) {
	 * JDateChooser date_data_despesa = new JDateChooser();
	 * date_data_despesa.setBounds(194, 168, 131, 19); 
	 * } 
	 * return date_data_despesa; 
	 * }
	 */

	public JButton getBtn_cadastrar_despesa() {
		if (btn_cadastrar_despesa == null) {
			btn_cadastrar_despesa = new JButton("Cadastrar");
			btn_cadastrar_despesa.setBounds(155, 260, 115, 23);
			btn_cadastrar_despesa.addActionListener(this);
		}
		return btn_cadastrar_despesa;
	}

	public JButton getBtn_cancelar_cadastro_despesa() {
		if (btn_cancelar_cadastro_despesa == null) {
			btn_cancelar_cadastro_despesa = new JButton("Cancelar");
			btn_cancelar_cadastro_despesa.setBounds(293, 260, 103, 23);
			btn_cancelar_cadastro_despesa.addActionListener(this);
		}
		return btn_cancelar_cadastro_despesa;
	}

	public JLabel getLbl_descricao_despesa() {
		if (lbl_descricao_despesa == null) {
			lbl_descricao_despesa = new JLabel("Descri\u00E7\u00E3o da despesa: ");
			lbl_descricao_despesa.setFont(new Font("Arial", Font.PLAIN, 13));
			lbl_descricao_despesa.setBounds(38, 202, 151, 14);
		}
		return lbl_descricao_despesa;
	}

	public JTextField getText_descricao_despesa() {
		if (text_descricao_despesa == null) {
			text_descricao_despesa = new JTextField();
			text_descricao_despesa.setBounds(194, 199, 283, 20);
			text_descricao_despesa.setColumns(10);
		}
		return text_descricao_despesa;
	}

	public JTextField getText_valor_despesa() {
		if (text_valor_despesa == null) {
			text_valor_despesa = new JTextField();
			text_valor_despesa.setBounds(194, 130, 103, 20);
			text_valor_despesa.setColumns(10);
		}
		return text_valor_despesa;
	}

	public JTextField getText_codigo_despesa() {
		if (text_codigo_despesa == null) {
			text_codigo_despesa = new JTextField();
			text_codigo_despesa.setEnabled(false);
			text_codigo_despesa.setEditable(false);
			text_codigo_despesa.setBounds(194, 95, 103, 20);
			text_codigo_despesa.setColumns(10);
		}
		return text_codigo_despesa;
	}

	public JLabel getLbl_icone_despesas() {
		if (lbl_icone_despesas == null) {
			lbl_icone_despesas = new JLabel("");
			lbl_icone_despesas.setIcon(
					new ImageIcon("C:\\Users\\Iago Ramon\\eclipse-workspace\\LP3_Trabalho1\\Imagens\\despesas.png"));
			lbl_icone_despesas.setBounds(465, 20, 55, 25);
		}
		return lbl_icone_despesas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == getBtn_cadastrar_despesa()) {

			String data = sdf.format(getDateChooser().getDate());
			System.out.println(data);

			try {
				despesa = new Despesa();
				despesa.setId(Despesa.getCadDespesa().size()+1);
				despesa.setValor(Float.parseFloat(text_valor_despesa.getText()));
				despesa.setData(data);
				despesa.setDescricao(text_descricao_despesa.getText());
				Despesa.getCadDespesa().add(despesa);
				getText_valor_despesa().setText(null);
				getText_descricao_despesa().setText(null);
				JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Erro: " + e1.getMessage());
			}
		} else if (e.getSource() == getBtn_cancelar_cadastro_despesa()) {
			this.dispose();
			contPrin.setEnabled(true);
		}

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		contPrin.setEnabled(false);
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		contPrin.setEnabled(true);
		// arquivos.addArquivos(Despesa.getCadDespesa());
		for (Despesa add : Despesa.getCadDespesa()) {
			System.out.println(add.getValor() + " " + add.getDescricao() + " " + add.getData());
		}

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		// contPrin.setEnabled(true);
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
		// JOptionPane.showMessageDialog(null, "Teste");
		contPrin.setEnabled(false);
	}
}
