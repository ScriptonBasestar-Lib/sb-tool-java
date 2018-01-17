package org.scriptonbasestar.tool.mail;

import lombok.extern.slf4j.Slf4j;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @author archmagece
 * @since 2014. 11. 14.
 */
@Slf4j
public class SendEmailBySMTP {

	private final String username;
	private final String password;

	Properties props;

	public SendEmailBySMTP(String username, String password, String smtpHost, String smtpPort) {
		this.username = username;
		this.password = password;

		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.ssl.trust", smtpHost);
		props.put("mail.smtp.port", smtpPort);
	}

	public void simple(String fromEmail, String fromName, String toEmail, String toName, String subject, String content) {

		try {
			Message message = new MimeMessage(createSession());
			message.setFrom(new InternetAddress(fromEmail, fromName));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail, toName));
			message.setSubject(subject);
			message.setText(content);

			Transport.send(message);
			log.debug("sendEmail 이메일 전송 완료");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void html(String fromEmail, String fromName, String toEmail, String toName, String subject, String content) {

		try {
			Message message = new MimeMessage(createSession());
			message.setFrom(new InternetAddress(fromEmail, fromName));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail, toName));
			message.setSubject(subject);
			message.setContent(content, "text/html; charset=utf-8");

			Transport.send(message);
			log.debug("sendEmail 이메일 전송 완료");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private Session createSession(){
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		return session;
	}

}
