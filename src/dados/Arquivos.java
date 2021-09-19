package dados;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Despesa;
import modelo.Receita;

public class Arquivos {
	
	
	//private static Arquivos instancia;
	//private static List<Despesa> despesa;
	//private static List<Receita> receita;

	 //String strPathDespesa = "./eclipse-workspace/LP3_Trabalho1/Despesa.txt";
	//private String strPathReceita = "./eclipse-workspace/LP3_Trabalho1/Receita.txt";
	//private String strPathSaldo ="./eclipse-workspace/LP3_Trabalho1";
	public Arquivos() {
	}
	public static void addDespesa(List<Despesa> des) {
		String strPathDespesa = "/home/oem/eclipse-workspace/LP3_Trabalho1/Despesa.txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(strPathDespesa))){
			for (Despesa desp : des) {
				bw.write(desp.getId()+" "+desp.getData()+" "+desp.getDescricao()+" "
			+String.valueOf(desp.getValor()));
				bw.newLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addReceita(List<Receita> res) {
		String strPathDespesa = "/home/oem/eclipse-workspace/LP3_Trabalho1/Receita.txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(strPathDespesa))){
			for (Receita resc : res) {
				bw.write(resc.getId()+" "+resc.getData()+" "+resc.getDescricao()+" "
			+String.valueOf(resc.getValor()));
				bw.newLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	
}
