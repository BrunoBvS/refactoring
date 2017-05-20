package br.com.duplabrunodenise.nf.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NotaFiscal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double valorImposto;
	private double valorBruto;

	public NotaFiscal() {}

	public NotaFiscal(double valorImposto, double valorBruto) {
		this.setValorImposto(valorImposto);
		this.setValorBruto(valorBruto);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValorImposto() {
		return valorImposto;
	}

	public void setValorImposto(double valorImposto) {
		this.valorImposto = valorImposto;
	}

	public double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public double getValorTotal() {
		return this.valorBruto + this.valorImposto;
	}

}
