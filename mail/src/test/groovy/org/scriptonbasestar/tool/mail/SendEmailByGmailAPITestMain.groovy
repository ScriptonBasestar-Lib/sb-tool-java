package org.scriptonbasestar.tool.mail

import com.google.api.client.auth.oauth2.Credential
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.client.util.store.FileDataStoreFactory
import com.google.api.services.gmail.Gmail

import javax.mail.MessagingException

class SendEmailByGmailAPITestMain {

	static void main(String[] args) throws IOException, MessagingException {
		// Load client secrets.
		InputStream input = SendEmailByGmailAPI.class.getClassLoader().getResourceAsStream("credentials/~~~.json")
		Credential credential = SendEmailByGmailAPI.authorize(input, "8080", "/Callback")
		// Build a new authorized API client service.
		Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME)
				.build()
		sendMessage(service, "me", createEmail(
				"archmagece@gmail.com",
				"bot@polypia.net",
				"subject",
				"tetergrext"
		));
	}

}
