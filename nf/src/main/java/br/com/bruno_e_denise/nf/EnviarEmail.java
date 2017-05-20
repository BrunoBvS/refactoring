package br.com.bruno_e_denise.nf;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarEmail {
	
	public void enviarEmail(Fatura fatura) {
				
		final String username = "refatoracaoalfa2017@gmail.com";
		final String password = "refatoracao123";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("refatoracaoalfa2017@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("brunovieira2012@gmail.com"));
			message.setSubject("Aula Refatoração");
			message.setText("Refatoração Classes NF");

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
}
