package modelo;

import java.util.ArrayList;
import java.util.List;

public class Despesa {

	private String descricao;
	private double valor;
	private String data;
	private Integer id;
	private static List<Despesa> cadDespesa = new ArrayList<>();
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public static List<Despesa> getCadDespesa() {
		return cadDespesa;
	}
}
