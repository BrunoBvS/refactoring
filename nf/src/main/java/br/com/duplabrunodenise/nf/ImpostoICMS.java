package br.com.duplabrunodenise.nf;

public class ImpostoICMS implements ImpostoInterface {

	public Double getValor(Double fatura) {
		return fatura*0.11;
	}

}
