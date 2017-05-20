package br.com.bruno_e_denise.nf;

public class ImpostoISS implements ImpostoInterface {

	public Double getValor(Double fatura) {
		return fatura * 0.1;
	}

}
