package br.com.duplabrunodenise.nf;

public class ImpostoISS implements ImpostoInterface {

	public Double getValor(Double fatura) {
		return fatura * 0.1;
	}

}
