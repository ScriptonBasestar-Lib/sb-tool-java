package org.scriptonbasestar.tool.http.client;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.scriptonbasestar.tool.http.client.rest.http.WebReader;

/**
 * @athor archmagece
 * @since 2017-01-24 10
 */
@Slf4j
public class WebReaderTest {

	/*
	 * SSL 사용 관련 설정이 별도로 필요
	 *
	 * 서버에 설정을 하는게 좋다고 보지만.. 내가 관리하는 서버가 아닌경우
	 * jsse.enableSNIExtension=false
	 *
	 * https://www.lesstif.com/pages/viewpage.action?pageId=19365977
	 * http://bugs.java.com/bugdatabase/view_bug.do?bug_id=7127374
	 *
	 */
	@Test
	public void test() {
		System.setProperty("jsse.enableSNIExtension", "false");
		String page = WebReader.readPage("https://webtest.pizzahut.co.kr/", "UTF-8", false);
//		String page = WebReader.readPage("https://github.com/", "UTF-8", false);
		System.out.println(page);
	}

}
