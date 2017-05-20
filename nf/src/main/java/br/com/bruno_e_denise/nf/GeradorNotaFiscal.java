package br.com.bruno_e_denise.nf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeradorNotaFiscal {
	public void geraNota(Fatura f, Imposto imposto) {
		NotaFiscal notaFiscal = geraNotaFiscal(f, imposto);
		armazenarNoBanco(notaFiscal);
		enviarEmail(f);
	}

	private void enviarEmail(Fatura f) {
		EnviarEmail enviaEmail = new EnviarEmail();
		enviaEmail.enviarEmail(f);
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

	private NotaFiscal geraNotaFiscal(Fatura f, Imposto imposto) {
		double valorImposto = 0;

		valorImposto = imposto.getValor(f.getV());

		NotaFiscal notaFiscal = new NotaFiscal(valorImposto, f.getV());
		return notaFiscal;
	}
}
