package org.scriptonbasestar.tool.mail;

import lombok.Getter;
import lombok.Setter;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {

	@Getter
	@Setter
	private String username;

	@Getter
	@Setter
	private String password;

	public SMTPAuthenticator() {
		super();
	}

	public SMTPAuthenticator(String username, String password) {
		this.username = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
}
