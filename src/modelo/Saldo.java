package modelo;

public class Saldo {
	
	private double saldo;
	
	private String nome;
	
	public Saldo(){
		saldo = 0.0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
