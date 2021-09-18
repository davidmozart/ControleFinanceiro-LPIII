package modelo;

import java.util.ArrayList;
import java.util.List;

public class Despesa {

	private String descricao;
	private double valor;
	private String data;
	public static List<Despesa> cadDespesa = new ArrayList<>();
	
	public static List<Despesa> getCadDespesa() {
		return cadDespesa;
	}
	public static void setCadDespesa(List<Despesa> cadDespesa) {
		Despesa.cadDespesa = cadDespesa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}
