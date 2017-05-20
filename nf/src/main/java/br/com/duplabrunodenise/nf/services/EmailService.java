package br.com.duplabrunodenise.nf.services;

import br.com.duplabrunodenise.nf.Fatura;
import br.com.duplabrunodenise.nf.entities.NotaFiscal;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	
	EmailService() {}
	
	public static void envieEmail(Fatura fatura, NotaFiscal notaFiscal) {
				
		final String username = "refatoracaoalfa2017@gmail.com";
		final String password = "refatoracao123";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			String assuntoEmail = getAssuntoEmail();
			String conteudoEmail = getConteudoEmail(fatura, notaFiscal);

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("refatoracaoalfa2017@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("denisecz@gmail.com,brunovieira2012@gmail.com"));
			message.setSubject(assuntoEmail);
			message.setText(conteudoEmail);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new EmailNotSentException(e);
		}
	}

	private static String getAssuntoEmail() {
		return "Fatura";
	}

	private static String getConteudoEmail(Fatura fatura, NotaFiscal notaFiscal) {
		return "Caro " + fatura.getNomeCliente() + ", sua fatura de valor " + fatura.getValor() +
				" foi emitida com sucesso com imposto de " + notaFiscal.getValorImposto() + '.';
	}
	
}
