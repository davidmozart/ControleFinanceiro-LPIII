package controle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import modelo.Receita;
import visao.CadastroReceita;

public class ControleCadReceita extends CadastroReceita implements ActionListener, WindowListener{

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	private static final long serialVersionUID = 1L;
	
	private static ControleCadReceita instancia;
	private static ControladorPrincipal contPrin = ControladorPrincipal.getInstance();
	private static Receita receita;

	
	private JPanel panel_cadastro_despesa;
	private JPanel panel_principal_receitas;
	private JLabel lblNovaReceita;
	private JLabel lbl_codigo_receita;
	private JLabel lbl_valor_receita;
	private JLabel lbl_data_receita;
	private JDateChooser date_data_receita;
	private JButton btn_cadastrar_receita;
	private JButton btn_cancelar_cadastro_receita;
	private JLabel lbl_descricao_despesa;
	private JTextField textField_descri_receita;
	private JFormattedTextField textField_valor_receita;
	private JTextField textField_codigo_receita;
	private JLabel lbl_icon_receita;
	
	private ControleCadReceita() {
		addEventos();
	}
	private void addEventos() {
		getContentPane().add(getPanel_cadastro_despesa(), BorderLayout.CENTER);
	}
	
	public static synchronized ControleCadReceita getInstance() {
		instancia = new ControleCadReceita();
		instancia.addWindowListener(instancia);
		return instancia;
	}

	public JPanel getPanel_cadastro_despesa() {
		if (panel_cadastro_despesa == null) {
			panel_cadastro_despesa = new JPanel();
			panel_cadastro_despesa.setLayout(null);
			panel_cadastro_despesa.setForeground(Color.WHITE);
			panel_cadastro_despesa.add(getPanel_principal_receitas());
			//panel_cadastro_despesa.add(getLbl_codigo_receita());
			panel_cadastro_despesa.add(getLbl_valor_receita());
			panel_cadastro_despesa.add(getLbl_data_receita());
			panel_cadastro_despesa.add(getBtn_cadastrar_receita());
			panel_cadastro_despesa.add(getBtn_cancelar_cadastro_receita());
			panel_cadastro_despesa.add(getLbl_descricao_despesa());
			panel_cadastro_despesa.add(getTextField_descri_receita());
			panel_cadastro_despesa.add(getTextField_valor_receita());
			//panel_cadastro_despesa.add(getTextField_codigo_receita());
			panel_cadastro_despesa.add(getDate_data_receita());
		}
		return panel_cadastro_despesa;
	}
	public JPanel getPanel_principal_receitas() {
		if (panel_principal_receitas == null) {
			panel_principal_receitas = new JPanel();
			panel_principal_receitas.setLayout(null);
			panel_principal_receitas.setBackground(new Color(119, 104, 255));
			panel_principal_receitas.setBounds(0, 0, 557, 62);
			panel_principal_receitas.add(getLblNovaReceita());
			panel_principal_receitas.add(getLbl_icon_receita());
		}
		return panel_principal_receitas;
	}
	public JLabel getLblNovaReceita() {
		if (lblNovaReceita == null) {
			lblNovaReceita = new JLabel("Nova receita");
			lblNovaReceita.setForeground(Color.WHITE);
			lblNovaReceita.setFont(new Font("Arial", Font.PLAIN, 22));
			lblNovaReceita.setBackground((Color) null);
			lblNovaReceita.setBounds(31, 20, 149, 31);
		}
		return lblNovaReceita;
	}
	public JLabel getLbl_codigo_receita() {
		if (lbl_codigo_receita == null) {
			lbl_codigo_receita = new JLabel("C\u00F3digo da receita:");
			lbl_codigo_receita.setFont(new Font("Arial", Font.PLAIN, 13));
			lbl_codigo_receita.setBounds(70, 95, 125, 14);
		}
		return lbl_codigo_receita;
	}
	public JLabel getLbl_valor_receita() {
		if (lbl_valor_receita == null) {
			lbl_valor_receita = new JLabel("Valor da receita: ");
			lbl_valor_receita.setFont(new Font("Arial", Font.PLAIN, 13));
			lbl_valor_receita.setBounds(80, 130, 115, 14);
		}
		return lbl_valor_receita;
	}
	public JLabel getLbl_data_receita() {
		if (lbl_data_receita == null) {
			lbl_data_receita = new JLabel("Data da receita:");
			lbl_data_receita.setFont(new Font("Arial", Font.PLAIN, 13));
			lbl_data_receita.setBounds(80, 168, 115, 14);
		}
		return lbl_data_receita;
	}
	
	public JDateChooser getDate_data_receita() {
		if (date_data_receita == null) {
			date_data_receita = new JDateChooser();
			date_data_receita.setBounds(195, 166, 152, 19);
		}
		return date_data_receita;
	}
	public JButton getBtn_cadastrar_receita() {
		if (btn_cadastrar_receita == null) {
			btn_cadastrar_receita = new JButton("Cadastrar");
			btn_cadastrar_receita.setBounds(169, 260, 105, 23);
			btn_cadastrar_receita.addActionListener(this);
		}
		return btn_cadastrar_receita;
	}
	public JButton getBtn_cancelar_cadastro_receita() {
		if (btn_cancelar_cadastro_receita == null) {
			btn_cancelar_cadastro_receita = new JButton("Cancelar");
			btn_cancelar_cadastro_receita.setBounds(300, 260, 105, 23);
			btn_cancelar_cadastro_receita.addActionListener(this);
		}
		return btn_cancelar_cadastro_receita;
	}
	public JLabel getLbl_descricao_despesa() {
		if (lbl_descricao_despesa == null) {
			lbl_descricao_despesa = new JLabel("Descrição da receita: ");
			lbl_descricao_despesa.setFont(new Font("Arial", Font.PLAIN, 13));
			lbl_descricao_despesa.setBounds(48, 205, 147, 14);
		}
		return lbl_descricao_despesa;
	}
	public JTextField getTextField_descri_receita() {
		if (textField_descri_receita == null) {
			textField_descri_receita = new JTextField();
			textField_descri_receita.setColumns(10);
			textField_descri_receita.setBounds(195, 203, 283, 20);
		}
		return textField_descri_receita;
	}
	public JFormattedTextField getTextField_valor_receita() {
		Locale.setDefault(Locale.US);
		if (textField_valor_receita == null) {
			textField_valor_receita = new JFormattedTextField(new DecimalFormat("#.00"));
			textField_valor_receita.setBounds(195, 128, 103, 20);
			textField_valor_receita.setColumns(10);
		}
		return textField_valor_receita;
	}
	public JTextField getTextField_codigo_receita() {
		if (textField_codigo_receita == null) {
			textField_codigo_receita = new JTextField();
			textField_codigo_receita.setEnabled(false);
			textField_codigo_receita.setEditable(false);
			textField_codigo_receita.setColumns(10);
			textField_codigo_receita.setBounds(195, 93, 103, 20);
		}
		return textField_codigo_receita;
	}
	public JLabel getLbl_icon_receita() {
		if (lbl_icon_receita == null) {
			lbl_icon_receita = new JLabel("");
			lbl_icon_receita.setIcon(new ImageIcon("C:\\Users\\Iago Ramon\\eclipse-workspace\\LP3_Trabalho1\\Imagens\\receitas.png"));
			lbl_icon_receita.setBounds(434, 20, 78, 25);
		}
		return lbl_icon_receita;
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
		contPrin.setEnabled(true);
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		//contPrin.setEnabled(true);
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
		contPrin.setEnabled(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn_cadastrar_receita) {
			String data = sdf.format(getDate_data_receita().getDate());
			try {
				receita = new Receita();
				receita.setId(Receita.getReceita().size()+1);
				receita.setDescricao(getTextField_descri_receita().getText());
				receita.setValor(Double.parseDouble(getTextField_valor_receita().getText()));
				receita.setData(data);
				ControladorPrincipal.addTabelaReceitaCad(receita.getId(), receita.getDescricao(), receita.getData(), receita.getValor());
				Receita.getReceita().add(receita);
				this.getTextField_descri_receita().setText(null);
				this.getTextField_valor_receita().setText(null);
				this.getDate_data_receita().setDate(null);
				JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");	
			}
			catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "erro: "+e1.getMessage());
			}
		}else if(e.getSource() == btn_cancelar_cadastro_receita) {
			
		}
	}
}
