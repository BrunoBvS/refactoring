package br.com.bruno_e_denise.nf;

import br.com.bruno_e_denise.nf.entities.NotaFiscal;
import br.com.bruno_e_denise.nf.services.BancoService;
import br.com.bruno_e_denise.nf.services.EmailService;

public class GeradorNotaFiscal {
	public void geraNota(Fatura fatura, ImpostoInterface imposto) {
		NotaFiscal notaFiscal = geraNotaFiscal(fatura, imposto);
		BancoService.persisteEntity(notaFiscal);
		EmailService.envieEmail(fatura, notaFiscal);
	}

	private NotaFiscal geraNotaFiscal(Fatura fatura, ImpostoInterface imposto) {
		final double valorDaFatura = fatura.getValor();
		final double valorImposto = imposto.getValor(valorDaFatura);
		final double valorBruto = fatura.getValor();

		NotaFiscal notaFiscal = new NotaFiscal(valorImposto, valorBruto);
		return notaFiscal;
	}
}
