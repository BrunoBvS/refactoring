package br.com.bruno_e_denise.nf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeradorNotaFiscal {
	public void geraNota(Fatura fatura, Imposto imposto) {
		NotaFiscal notaFiscal = geraNotaFiscal(fatura, imposto);
		armazenarNoBanco(notaFiscal);
		enviarEmail(fatura);
	}

	private void enviarEmail(Fatura fatura) {
		EnviarEmail enviaEmail = new EnviarEmail();
		enviaEmail.enviarEmail(fatura);
	}

	private void armazenarNoBanco(NotaFiscal notaFiscal) {
		// Armazenar no BD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(notaFiscal);

		em.getTransaction().commit();
		em.close();
	}

	private NotaFiscal geraNotaFiscal(Fatura fatura, Imposto imposto) {
		final double valorDaFatura = fatura.getValor();
		final double valorImposto = imposto.getValor(valorDaFatura);
		final double valorBruto = fatura.getValor();

		NotaFiscal notaFiscal = new NotaFiscal(valorImposto, valorBruto);
		return notaFiscal;
	}
}
