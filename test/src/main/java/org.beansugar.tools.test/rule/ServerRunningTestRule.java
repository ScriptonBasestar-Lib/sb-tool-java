package org.beansugar.tool.test.rule;

import org.junit.Assert;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author archmagece
 * @CreatedAt 2016-10-11 19
 */
public class ServerRunningTestRule implements TestRule {

	private final String serverUrl;
	public ServerRunningTestRule(String serverUrl ){
		this.serverUrl = serverUrl;
	}

	@Override
	public Statement apply(Statement base, Description description) {
		try {
			URL url = new URL(this.serverUrl);
			URLConnection urlConnection = url.openConnection();
			urlConnection.connect();
		} catch (MalformedURLException e) {
			Assert.fail("ServerRunningTestRule error - MalformedURLException");
		} catch (IOException e) {
			Assert.fail("ServerRunningTestRule error - IOException");
		}
		return base;
	}
}
