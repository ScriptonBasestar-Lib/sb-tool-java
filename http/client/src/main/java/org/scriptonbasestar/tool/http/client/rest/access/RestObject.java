package org.scriptonbasestar.tool.http.client.rest.access;


import org.scriptonbasestar.tool.http.client.rest.type.EncodingType;
import org.scriptonbasestar.tool.http.client.rest.type.HttpMethod;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : archmagece@gmail.com
 * @since: 2014-03-06 10:53
 */
public class RestObject {

	private final EncodingType encodingType;
	private final Map<String, String> headers;

	public RestObject() {
		this(EncodingType.UTF8);
	}

	public RestObject(EncodingType encodingType) {
		this(encodingType, new HashMap<String, String>());
	}

	public RestObject(EncodingType encodingType, Map<String, String> headers) {
		this.encodingType = encodingType;
		this.headers = headers;
	}

	/**
	 * @param httpMethod
	 * @param urlString
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public String getWebResource(String urlString, HttpMethod httpMethod, Map<?, ?> params) throws MalformedURLException, IOException {
		HttpURLConnection connection = null;
		BufferedReader bufferedReader = null;

		//create parameter string
		StringBuilder sbParams = new StringBuilder();
		for (Map.Entry entry : params.entrySet()) {
			sbParams.append(URLEncoder.encode(entry.getKey().toString(), encodingType.toString()))
					.append('=')
					.append(URLEncoder.encode(entry.getValue().toString(), encodingType.toString()))
					.append('&');
		}
		sbParams.deleteCharAt(sbParams.length() - 1);

		//CREATE urlDomainHttp
		//URL urlDomainHttp = new URL(urlString);
		if (httpMethod == HttpMethod.GET && sbParams.length() != 0) {
			urlString = urlString + '?' + sbParams.toString();
		}
		connection = (HttpURLConnection) new URL(urlString).openConnection();
		connection.setRequestMethod(httpMethod.name());

		//SET POST parameter
		if (httpMethod == HttpMethod.POST && sbParams != null && sbParams.length() != 0) {
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter((connection.getOutputStream()));
			outputStreamWriter.write(sbParams.toString());
			outputStreamWriter.flush();
		}

		//create header string
		for (Map.Entry<String, String> entry : headers.entrySet()) {
			connection.setRequestProperty(entry.getKey(), entry.getValue());
		}

		int responseCode = connection.getResponseCode();

		bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encodingType.toString()));
		String line = null;
		StringBuilder sbResult = new StringBuilder();
		while ((line = bufferedReader.readLine()) != null) {
			sbResult.append(line);
		}
		return sbResult.toString();
	}

	public String paramCreator(Map<?, ?> params) throws UnsupportedEncodingException {
		StringBuilder sbParams = new StringBuilder();
		for (Map.Entry entry : params.entrySet()) {
			sbParams.append(URLEncoder.encode(entry.getKey().toString(), encodingType.toString()))
					.append('=')
					.append(URLEncoder.encode(entry.getValue().toString(), encodingType.toString()))
					.append('&');
		}
		sbParams.deleteCharAt(sbParams.length() - 1);
		return sbParams.toString();
	}
}
