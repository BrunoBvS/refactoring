package br.com.duplabrunodenise.nf.services;

import javax.mail.MessagingException;

@SuppressWarnings("serial")
public class EmailNotSentException extends RuntimeException {
	public EmailNotSentException(MessagingException e) {
		super(e);
	}
}
