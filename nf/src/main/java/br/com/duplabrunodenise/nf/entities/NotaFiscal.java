package br.com.duplabrunodenise.nf.entities;

import java.text.DecimalFormat;

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
	
	private static final DecimalFormat formatadorTextual = new DecimalFormat("#.00");

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

	public String getValorImpostoTextual() {
		return formatadorTextual.format(this.getValorImposto());
	}

	public void setValorImposto(double valorImposto) {
		this.valorImposto = valorImposto;
	}

	public double getValorBruto() {
		return valorBruto;
	}

	public String getValorBrutoTextual() {
		return formatadorTextual.format(this.getValorBruto());
	}

	public void setValorBruto(double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public double getValorTotal() {
		return this.valorBruto + this.valorImposto;
	}

	public String getValorTotalTextual() {
		return formatadorTextual.format(this.getValorTotal());
	}

}
