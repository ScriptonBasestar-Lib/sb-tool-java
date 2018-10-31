package org.scriptonbasestar.tool.collection.joiner;

import org.junit.Assert;
import org.junit.Test;
import org.scriptonbasestar.tool.collection.builder.ListBuilder;

import java.util.List;

/**
 * @author archmagece
 * @since 2017-09-06
 */
public class JoinerTest {


	@Test
	public void test_Joiner_run() {
		//given
		List<String> list = ListBuilder.create("33", "fefe", "fww", "jiojio", "sdfjjksfkjfld").build();
		//when
		String result = Joiner.<String>on(",").append(list).join();
		//then
		System.out.println(result);
		String expectedString = "33,fefe,fww,jiojio,sdfjjksfkjfld";
		Assert.assertEquals(result, expectedString);
	}

}
