package dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import modelo.Despesa;
import modelo.Receita;

public class Arquivos {
	
	
	private static String strPathReceita = "/home/oem/eclipse-workspace/ControleFinanceiro-LPIII/Receita.txt";
	private static String strPathDespesa = "/home/oem/eclipse-workspace/ControleFinanceiro-LPIII/Despesa.txt"; 
	
	private static Despesa despesa;
	private static Receita receita;
	File arquivo;
	

	public Arquivos() {
	}
	
	public static void addDespesa() {
		//if (Despesa.getCadDespesa().size() != 0) {
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(strPathDespesa))) {
				for (Despesa desp : Despesa.getCadDespesa()) {
					bw.write(desp.getId() + " " + desp.getData() + " " + desp.getDescricao() + " "
							+ String.valueOf(desp.getValor()));
					bw.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	//}
	
	public static void addReceita() {
		//if (Receita.getReceita().size() != 0) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(strPathReceita))) {
				for (Receita resc : Receita.getReceita()) {
					bw.write(resc.getId() + " " + resc.getData() + " " + resc.getDescricao() + " "
							+ String.valueOf(resc.getValor()));
					bw.newLine();
				}
			} catch (IOException e) {
				JOptionPane.showInternalMessageDialog(null, "Erro na gravação do arquivo: "+e.getMessage());
			}
		}
	//}
	
	public static void readDespesa() {
		try(BufferedReader br = new BufferedReader(new FileReader(strPathDespesa))){
			String itemCsv = br.readLine();
			while (itemCsv != null) {
				despesa = new Despesa();
				String[] fields = itemCsv.split(" ");
				despesa.setId(Integer.parseInt(fields [0])); 
				despesa.setData(fields[1]);
				despesa.setDescricao(fields [2]);
				despesa.setValor(Double.parseDouble(fields[3]));

				Despesa.getCadDespesa().add(despesa);
				itemCsv = br.readLine();
			}
		}
		catch (IOException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro na leitura do arquivo: "+e.getMessage());
		}
	}
	
	public static void readReceita() {
		try(BufferedReader br = new BufferedReader(new FileReader(strPathReceita))){
			String itemCsv = br.readLine();
			while (itemCsv != null) {
				receita = new Receita();
				String[] fields = itemCsv.split(" ");
				receita.setId(Integer.parseInt(fields [0])); 
				receita.setData(fields[1]);
				receita.setDescricao(fields [2]);
				receita.setValor(Double.parseDouble(fields[3]));
				Receita.getReceita().add(receita);
				itemCsv = br.readLine();
			}
		}
		catch (IOException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro na leitura do arquivo: "+e.getMessage());
		}
	}


	
}
