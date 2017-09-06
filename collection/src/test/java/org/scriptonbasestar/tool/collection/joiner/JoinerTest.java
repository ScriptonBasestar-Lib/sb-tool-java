package org.scriptonbasestar.tool.collection.joiner;

import org.junit.Test;
import org.scriptonbasestar.tool.collection.builder.ListBuilder;

import java.util.List;

/**
 * @author chaeeung.e
 * @since 2017-09-06
 */
public class JoinerTest {

	@Test
	public void test_Joiner_run(){
		List<String> list = ListBuilder.create("33","fefe","fww","jiojio","sdfjjksfkjfld").build();
		String result = Joiner.on(",").append(list).join();
		System.out.println(result);
	}

}
