package br.com.duplabrunodenise.nf;

public class Fatura {
	private String nomeCliente;
	private double valor;

	public Fatura(String nomeCliente, double valor) {
		this.setNomeCliente(nomeCliente);
		this.setValor(valor);
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
