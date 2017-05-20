package br.com.duplabrunodenise.nf;

import br.com.duplabrunodenise.nf.entities.NotaFiscal;
import br.com.duplabrunodenise.nf.services.BancoService;
import br.com.duplabrunodenise.nf.services.EmailService;

public class GeradorNotaFiscal {
	public NotaFiscal geraNota(Fatura fatura, ImpostoInterface imposto) {
		NotaFiscal notaFiscal = geraNotaFiscal(fatura, imposto);
		BancoService.persisteEntity(notaFiscal);
		EmailService.envieEmail(fatura, notaFiscal);
		return notaFiscal;
	}

	private NotaFiscal geraNotaFiscal(Fatura fatura, ImpostoInterface imposto) {
		final double valorDaFatura = fatura.getValor();
		final double valorImposto = imposto.getValor(valorDaFatura);
		final double valorBruto = fatura.getValor();

		return new NotaFiscal(valorImposto, valorBruto);
	}
}
