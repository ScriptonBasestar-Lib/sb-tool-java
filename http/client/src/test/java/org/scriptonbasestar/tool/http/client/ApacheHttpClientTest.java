package org.scriptonbasestar.tool.http.client;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @author chaeeung.e
 * @since 2017-09-01
 */
public class ApacheHttpClientTest {

	public static CloseableHttpClient createHttpClient(int timeout) {
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create().setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig);

		return httpClientBuilder.build();
	}





}
